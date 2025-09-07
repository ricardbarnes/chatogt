package cat.vonblum.chatogt.shared.infrastructure.bus.command.kafka

import cat.vonblum.chatogt.shared.infrastructure.bus.command.shared.MessageEnvelope
import cat.vonblum.chatogt.shared.infrastructure.bus.command.shared.MessageProducer
import org.springframework.kafka.core.KafkaTemplate

class KafkaMessageProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>,
    private val topicResolver: (MessageEnvelope) -> String
) : MessageProducer {

    override fun send(envelope: MessageEnvelope) {
        val topic = topicResolver(envelope)
        kafkaTemplate.send(topic, envelope.key, envelope.payload)
    }

}
