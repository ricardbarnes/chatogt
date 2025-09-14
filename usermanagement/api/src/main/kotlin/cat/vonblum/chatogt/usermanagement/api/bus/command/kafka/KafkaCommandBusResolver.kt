package cat.vonblum.chatogt.usermanagement.api.bus.command.kafka

import cat.vonblum.chatogt.shared.infrastructure.bus.MessageEnvelope
import cat.vonblum.chatogt.usermanagement.api.properties.users.SpringUserCommandBusProperties

/**
 * Resolves Kafka topics based on Spring Boot configuration and envelope type.
 */
class KafkaCommandBusResolver(
    private val userBusProps: SpringUserCommandBusProperties
    // add further aggregate properties upon here
) {

    fun resolve(envelope: MessageEnvelope): String {
        val props = when (envelope.aggregate.lowercase()) {
            "users" -> userBusProps
            // add further aggregate names upon here
            else -> throw IllegalStateException(
                "Unknown aggregate ${envelope.aggregate.lowercase()}"
            )
        }

        return props.commandBus.kafka.topic
    }

}