package cat.vonblum.chatogt.usermanagement.consumer.handler.users.kafka

import cat.vonblum.chatogt.usermanagement.consumer.repository.Projector
import cat.vonblum.chatogt.usermanagement.infrastructure.bus.shared.kafka.KafkaHeader
import cat.vonblum.chatogt.usermanagement.infrastructure.event.EventStore
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import user.User

class KafkaUserEventHandler(
    private val store: EventStore,
    private val projector: Projector,
    private val mapper: KafkaUserEventMapper
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
        store.append(event)
        projector.apply(event)
    }

}