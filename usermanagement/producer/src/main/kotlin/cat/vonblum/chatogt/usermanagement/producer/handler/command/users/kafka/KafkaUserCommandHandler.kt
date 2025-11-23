package cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka

import cat.vonblum.chatogt.usermanagement.domain.command.Command
import cat.vonblum.chatogt.usermanagement.infrastructure.handler.command.CommandDispatcher

class KafkaUserCommandHandler(
    private val mapper: KafkaUserCommandMapper,
    private val dispatcher: CommandDispatcher
) {

    fun handle(command: Command) {
        // TODO
    }

}