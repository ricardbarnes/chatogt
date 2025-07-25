package cat.vonblum.chatogt.chats.producer.bus.query

import org.apache.kafka.clients.producer.KafkaProducer
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class KafkaResponseBus(
    private val mapper: KafkaResponseMapper,
    private val producer: KafkaProducer<UUID, String>,
    @Value("\${kafka.topics.responses}") private val topic: String
) {

    // TODO

}