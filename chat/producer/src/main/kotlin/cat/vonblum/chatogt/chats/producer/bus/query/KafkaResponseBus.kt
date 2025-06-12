package cat.vonblum.chatogt.chats.producer.bus.query

import cat.vonblum.chatogt.shared.domain.annotation.DrivenAdapter
import org.apache.kafka.clients.producer.KafkaProducer
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.UUID

@DrivenAdapter
@Component
class KafkaResponseBus(
    private val mapper: KafkaResponseMapper,
    private val producer: KafkaProducer<UUID, String>,
    @Value("\${kafka.topics.responses}") private val topic: String
) {

    // TODO

}