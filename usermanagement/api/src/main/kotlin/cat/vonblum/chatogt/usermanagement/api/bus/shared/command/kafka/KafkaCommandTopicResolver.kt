package cat.vonblum.chatogt.usermanagement.api.bus.shared.command.kafka

import cat.vonblum.chatogt.shared.infrastructure.bus.command.shared.MessageEnvelope
import cat.vonblum.chatogt.usermanagement.api.config.shared.springboot.command.SpringbootCommandBusProperties

/**
 * Resolves Kafka topics based on Spring Boot configuration.
 * Reads topics from [SpringbootCommandBusProperties] for each aggregate.
 */
class KafkaCommandTopicResolver(
    private val properties: SpringbootCommandBusProperties
) {

    /**
     * Resolves the Kafka topic for a given envelope.
     *
     * @throws IllegalArgumentException if no topic is configured for the aggregate
     */
    fun resolve(envelope: MessageEnvelope): String {
        return when (envelope.aggregate.lowercase()) {
            "users" -> properties.users.kafka.topic
            // add more aggregates here if needed, e.g. "chats" -> properties.chats.kafka.topic
            else -> throw IllegalArgumentException(
                "No Kafka topic configured for aggregate '${envelope.aggregate}'"
            )
        }
    }

}
