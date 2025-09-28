package cat.vonblum.chatogt.usermanagement.producer.handler.shared.kafka

import cat.vonblum.chatogt.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.shared.domain.query.QueryHandler
import cat.vonblum.chatogt.shared.infrastructure.message.Message
import cat.vonblum.chatogt.shared.infrastructure.message.MessageResolver

class KafkaMessageResolver(
    commandHandlers: List<CommandHandler>,
    queryHandlers: List<QueryHandler>,
    mapper: KafkaMessageMapper
) : MessageResolver {

    override fun resolve(message: Message) {
        // TODO
        println("Processing message: $message")
    }

}
