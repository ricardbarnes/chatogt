package cat.vonblum.chatogt.shared.infrastructure.bus.shared.spring

import cat.vonblum.chatogt.shared.infrastructure.bus.shared.MessageConsumer
import cat.vonblum.chatogt.shared.infrastructure.bus.shared.MessageEnvelope
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class SpringKafkaMessageSubscriber(private val handler: (MessageEnvelope) -> Unit, ) : MessageConsumer {

    override fun consume(envelope: MessageEnvelope) {
        handler(envelope)
    }

    @KafkaListener(
        topics = ["\${kafka.consumer.topic}"],
        groupId = "\${kafka.consumer.group-id}"
    )
    fun onMessage(
        payload: String,
        @Header("type") type: String?,
        @Header("aggregate", required = false) aggregate: String?,
        @Header("name", required = false) name: String?,
        @Header("key", required = false) key: String?
    ) {
        val envelope = MessageEnvelope(
            aggregate = aggregate ?: "unknownAggregate",
            type = type ?: "unknownType",
            name = name ?: "unknownName",
            key = key ?: UUID.randomUUID().toString(),
            payload = payload,
        )
        consume(envelope)
    }

}