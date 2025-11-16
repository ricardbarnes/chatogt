package cat.vonblum.chatogt.usermanagement.producer.handler.shared.spring

import cat.vonblum.chatogt.shared.infrastructure.io.message.Message
import cat.vonblum.chatogt.shared.infrastructure.io.message.MessageResolver
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Header
import java.util.*

class SpringKafkaSubscriber(private val resolver: MessageResolver) {

    @KafkaListener(
        groupId = "\${handler.shared.kafka.consumer-group-id}",
        topics = [
            "\${handler.commands.users.kafka.topic}",
            "\${handler.queries.users.kafka.topic}"
        ],
    )
    fun onMessage(
        payload: String,
        @Header("type") type: String?,
        @Header("aggregate", required = false) aggregate: String?,
        @Header("name", required = false) name: String?,
        @Header("key", required = false) key: String?
    ) {
        val message = Message(
            aggregate = aggregate ?: "unknownAggregate",
            type = type ?: "unknownType",
            name = name ?: "unknownName",
            key = key ?: UUID.randomUUID().toString(),
            payload = payload,
        )
        resolver.resolve(message)
    }

}