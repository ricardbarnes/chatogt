package cat.vonblum.chatogt.chats.producer.bus

import cat.vonblum.chatogt.chats.producer.mapper.KafkaEventMapper
import cat.vonblum.chatogt.shared.domain.event.Event
import cat.vonblum.chatogt.shared.domain.event.EventBus
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
    @Value("\${kafka.topics.events}") private val topic: String
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