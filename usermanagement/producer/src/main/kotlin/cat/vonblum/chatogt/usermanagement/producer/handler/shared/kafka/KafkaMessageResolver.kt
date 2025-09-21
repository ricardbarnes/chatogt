package cat.vonblum.chatogt.usermanagement.producer.handler.shared.kafka

import cat.vonblum.chatogt.shared.infrastructure.bus.shared.MessageEnvelope
import cat.vonblum.chatogt.shared.infrastructure.bus.shared.MessageResolver
import cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka.KafkaUserCommandHandler
import cat.vonblum.chatogt.usermanagement.producer.handler.query.users.kafka.KafkaUserQueryHandler

class KafkaMessageResolver(
    private val commandHandler: KafkaUserCommandHandler,
    private val queryHandler: KafkaUserQueryHandler
) : MessageResolver {

    override fun resolve(envelope: MessageEnvelope) {
        when (envelope.type.lowercase()) {
            "command" -> commandHandler.handle(envelope)
            "query" -> queryHandler.handle(envelope)
            else -> throw IllegalArgumentException(
                "Unsupported message type: ${envelope.type}"
            )
        }
    }

}
