package cat.vonblum.chatogt.usermanagement.consumer.handler.users.kafka

import cat.vonblum.chatogt.usermanagement.consumer.projection.users.UserProjection
import cat.vonblum.chatogt.usermanagement.shared.event.EventStore
import cat.vonblum.chatogt.usermanagement.infrastructure.bus.shared.kafka.KafkaHeader
import cat.vonblum.chatogt.usermanagement.users.UserId
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import user.User

class KafkaUserEventHandler(
    private val mapper: KafkaUserEventMapper,
    private val store: EventStore,
    private val projection: UserProjection
) {

    @KafkaListener(
        topics = ["\${handler.events.users.kafka.topic}"],
        groupId = "\${spring.kafka.consumer.group-id}"
    )
    fun handle(record: ConsumerRecord<String, ByteArray>) {
        when (
            val protoType = record.headers()
                .lastHeader(KafkaHeader.PROTO_TYPE)
                ?.value()
                ?.toString(Charsets.UTF_8)
        ) {
            User.UserCreatedEvent::class.java.simpleName -> {
                val proto = User.UserCreatedEvent.parseFrom(record.value())
                handle(proto)
            }

            else -> {
                println("Unknown proto type: $protoType")
                return
            }
        }
    }

    private fun handle(dto: User.UserCreatedEvent) {
        val event = mapper.toDomain(dto)
        store.append(UserId(event.aggregateId), 0, listOf(event)) // TODO: manage expected version
        projection.apply(event)
    }

}