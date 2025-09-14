package cat.vonblum.chatogt.usermanagement.api.bus.query.kafka

import cat.vonblum.chatogt.shared.infrastructure.bus.MessageEnvelope
import cat.vonblum.chatogt.usermanagement.api.properties.users.SpringUserQueryBusProps

class KafkaQueryBusResolver(
    private val userBusProps: SpringUserQueryBusProps
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

        return props.kafka.topic
    }

}