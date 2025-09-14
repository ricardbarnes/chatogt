package cat.vonblum.chatogt.usermanagement.api.bus.shared.kafka

import cat.vonblum.chatogt.shared.infrastructure.bus.MessageEnvelope
import cat.vonblum.chatogt.usermanagement.api.properties.users.SpringUserProperties

/**
 * Resolves Kafka topics based on Spring Boot configuration and envelope type.
 */
class KafkaTopicResolver(
    private val userProperties: SpringUserProperties
    // add further aggregate properties upon here
) {

    fun resolve(envelope: MessageEnvelope): String {
        val props = when (envelope.aggregate.lowercase()) {
            "users" -> userProperties
            // add further aggregate names upon here
            else -> throw IllegalStateException(
                "Unknown aggregate ${envelope.aggregate.lowercase()}"
            )
        }

        return when (envelope.type.lowercase()) {
            "command" -> props.commandBus.kafka.topic
            "query" -> props.queryBus.kafka.topic
            "response" -> props.responsesBus.kafka.topic
            else -> throw IllegalArgumentException(
                "Unsupported envelope type '${envelope.type}'"
            )
        }
    }

}
