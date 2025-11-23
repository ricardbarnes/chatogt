package cat.vonblum.chatogt.chat.producer.bus.event.kafka

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.domain.event.EventBus
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.header.Headers
import org.apache.kafka.common.header.internals.RecordHeaders
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.UUID
import kotlin.reflect.KClass

@Component
class KafkaEventBus(
    private val mapper: KafkaEventMapper,
    private val producer: KafkaProducer<UUID, String>,
    @param:Value("\${kafka.topics.events}") private val topic: String
) : EventBus {

    override fun publish(events: List<Event>) {
        events.forEach { event ->
            producer.send(
                ProducerRecord(
                    topic,
                    null,
                    event.id,
                    mapper.toDto(event),
                    aHeaders(event::class)
                )
            )
        }
    }

    private fun aHeaders(clazz: KClass<*>): Headers {
        val headers = RecordHeaders()
        headers.add("type", clazz.qualifiedName?.toByteArray())
        return headers
    }

}