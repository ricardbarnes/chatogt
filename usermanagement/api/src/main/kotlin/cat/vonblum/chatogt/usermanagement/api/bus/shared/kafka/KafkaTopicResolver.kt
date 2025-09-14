package cat.vonblum.chatogt.usermanagement.api.bus.shared.kafka

import cat.vonblum.chatogt.shared.infrastructure.bus.MessageEnvelope
import cat.vonblum.chatogt.usermanagement.api.config.shared.spring.SpringCommandBusProperties

/**
 * Resolves Kafka topics based on Spring Boot configuration and envelope type.
 */
class KafkaTopicResolver(
    private val properties: SpringCommandBusProperties
) {

    fun resolve(envelope: MessageEnvelope): String {
        val aggregate = envelope.aggregate.lowercase()

        val aggregateProps = when (envelope.type.lowercase()) {
            "command" -> properties.command[aggregate]
            "query" -> properties.queries[aggregate]
            "response" -> properties.responses[aggregate]
            else -> throw IllegalArgumentException(
                "Unsupported envelope type '${envelope.type}'"
            )
        } ?: throw IllegalArgumentException(
            "No Kafka topic configured for aggregate '$aggregate' and type '${envelope.type}'"
        )

        return aggregateProps.kafka.topic
    }

}