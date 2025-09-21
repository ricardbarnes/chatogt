package cat.vonblum.chatogt.usermanagement.producer.handler.shared.kafka

import cat.vonblum.chatogt.shared.infrastructure.bus.shared.MessageEnvelope
import cat.vonblum.chatogt.shared.infrastructure.bus.shared.MessageResolver
import cat.vonblum.chatogt.usermanagement.producer.handler.command.kafka.KafkaCommandHandler
import cat.vonblum.chatogt.usermanagement.producer.handler.query.kafka.KafkaQueryHandler

class KafkaMessageResolver(
    private val commandHandler: KafkaCommandHandler,
    private val queryHandler: KafkaQueryHandler
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
