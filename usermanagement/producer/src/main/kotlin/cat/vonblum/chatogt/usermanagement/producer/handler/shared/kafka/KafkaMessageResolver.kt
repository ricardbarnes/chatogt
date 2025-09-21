package cat.vonblum.chatogt.usermanagement.producer.handler.shared.kafka

import cat.vonblum.chatogt.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.shared.domain.query.QueryHandler
import cat.vonblum.chatogt.shared.infrastructure.bus.shared.Message
import cat.vonblum.chatogt.shared.infrastructure.bus.shared.MessageResolver

class KafkaMessageResolver(
    commandHandlers: List<CommandHandler>,
    queryHandlers: List<QueryHandler>
) : MessageResolver {

    override fun resolve(message: Message) {
        TODO()
    }

}
