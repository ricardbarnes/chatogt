package cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka

import cat.vonblum.chatogt.shared.domain.command.Command
import cat.vonblum.chatogt.shared.infrastructure.handler.command.CommandDispatcher

class KafkaUserCommandHandler(
    private val mapper: KafkaUserCommandMapper,
    private val dispatcher: CommandDispatcher
) {

    fun handle(command: Command) {
        // TODO
    }

}