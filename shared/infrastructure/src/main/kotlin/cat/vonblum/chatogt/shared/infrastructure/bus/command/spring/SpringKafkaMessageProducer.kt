package cat.vonblum.chatogt.shared.infrastructure.bus.command.spring

import cat.vonblum.chatogt.shared.infrastructure.bus.MessageEnvelope
import cat.vonblum.chatogt.shared.infrastructure.bus.MessageProducer
import org.springframework.kafka.core.KafkaTemplate

class SpringKafkaMessageProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>,
    private val topicResolver: (MessageEnvelope) -> String
) : MessageProducer {

    override fun send(envelope: MessageEnvelope) {
        val topic = topicResolver(envelope)
        kafkaTemplate.send(topic, envelope.key, envelope.payload)
    }

}