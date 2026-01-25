package cat.vonblum.chatogt.usermanagement.producer.bus.event.kafka

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.domain.event.UnsupportedEvent
import cat.vonblum.chatogt.usermanagement.infrastructure.bus.shared.kafka.KafkaHeader
import cat.vonblum.chatogt.usermanagement.shared.config.SpringBusProps
import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.header.internals.RecordHeader
import org.springframework.kafka.core.KafkaTemplate
import user.User
import java.util.*

class KafkaEventBus(
    private val template: KafkaTemplate<String, ByteArray>,
    private val mapper: KafkaEventMapper,
    private val props: SpringBusProps
) : EventBus {

    override fun publish(events: List<Event>) {
        events.forEach { event ->
            when (event) {
                is UserCreatedEvent -> dispatchUserCreatedEvent(event)
            }
        }
    }

    private fun dispatchUserCreatedEvent(event: UserCreatedEvent) {
        val topic = props.events["users"]?.kafka?.topic ?: throw UnsupportedEvent.becauseOf(event)
        val payload = mapper.toInfra(event)
        val record = ProducerRecord(
            topic,
            UUID.randomUUID().toString(),
            payload,
        ).apply {
            headers().add(
                RecordHeader(
                    KafkaHeader.PROTO_TYPE,
                    User.UserCreatedEvent::class.java.simpleName.toByteArray(),
                )
            )
        }

        template.send(record)
    }

}