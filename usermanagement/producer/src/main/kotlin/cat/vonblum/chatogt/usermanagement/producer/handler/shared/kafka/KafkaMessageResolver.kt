package cat.vonblum.chatogt.usermanagement.producer.handler.shared.kafka

import cat.vonblum.chatogt.shared.domain.command.Command
import cat.vonblum.chatogt.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.shared.domain.query.Query
import cat.vonblum.chatogt.shared.domain.query.QueryHandler
import cat.vonblum.chatogt.shared.infrastructure.io.message.Message
import cat.vonblum.chatogt.shared.infrastructure.io.message.MessageResolver
import kotlin.reflect.KClass

class KafkaMessageResolver(
    commandHandlers: Map<KClass<out Command>, CommandHandler>,
    queryHandlers: Map<KClass<out Query>, QueryHandler>,
    mapper: KafkaMessageMapper
) : MessageResolver {

    override fun resolve(message: Message) {
        // TODO
        println("Processing message: $message")
    }

}
