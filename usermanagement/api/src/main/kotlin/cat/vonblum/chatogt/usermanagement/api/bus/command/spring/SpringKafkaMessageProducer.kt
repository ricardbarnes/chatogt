package cat.vonblum.chatogt.usermanagement.api.bus.command.spring

import cat.vonblum.chatogt.shared.infrastructure.io.message.Message
import cat.vonblum.chatogt.shared.infrastructure.io.message.MessageProducer
import cat.vonblum.chatogt.usermanagement.api.bus.command.kafka.KafkaCommandMapper
import org.springframework.kafka.core.KafkaTemplate

class SpringKafkaMessageProducer(
    private val template: KafkaTemplate<ByteArray, ByteArray>,
    private val topicResolver: (Message) -> String,
    private val commandMapper: KafkaCommandMapper
) : MessageProducer {

    override fun send(message: Message) {
        val topic = topicResolver(message)
        val payload = map(message.payload)
        template.send(
            topic,
            message.key.toByteArray(),
            payload
        )
    }

    fun map(payload: Any): ByteArray {
        TODO()
    }

}