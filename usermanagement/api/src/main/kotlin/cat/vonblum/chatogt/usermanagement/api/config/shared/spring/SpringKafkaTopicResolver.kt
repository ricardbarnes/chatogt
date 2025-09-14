package cat.vonblum.chatogt.usermanagement.api.config.shared.spring

import cat.vonblum.chatogt.shared.infrastructure.bus.MessageEnvelope
import cat.vonblum.chatogt.usermanagement.api.config.shared.spring.SpringBusProps

class SpringKafkaTopicResolver(private val busProps: SpringBusProps) {

    fun resolve(envelope: MessageEnvelope): String {
        val busMap = when (envelope.type.lowercase()) {
            "command" -> busProps.commands
            "query" -> busProps.queries
            "response" -> busProps.responses
            else -> throw IllegalArgumentException("Unsupported envelope type '${envelope.type}'")
        }

        return busMap[envelope.aggregate.lowercase()]?.kafka?.topic
            ?: throw IllegalStateException("No config for aggregate '${envelope.aggregate}' and type '${envelope.type}'")
    }

}