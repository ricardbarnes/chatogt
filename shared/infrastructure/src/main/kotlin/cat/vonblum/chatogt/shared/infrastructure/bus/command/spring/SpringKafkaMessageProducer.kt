package cat.vonblum.chatogt.shared.infrastructure.bus.command.spring

import cat.vonblum.chatogt.shared.infrastructure.bus.shared.Message
import cat.vonblum.chatogt.shared.infrastructure.bus.shared.MessageProducer
import org.springframework.kafka.core.KafkaTemplate

class SpringKafkaMessageProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>,
    private val topicResolver: (Message) -> String
) : MessageProducer {

    override fun send(envelope: Message) {
        val topic = topicResolver(envelope)
        kafkaTemplate.send(topic, envelope.key, envelope.payload)
    }

}