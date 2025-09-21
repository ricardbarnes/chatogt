package cat.vonblum.chatogt.usermanagement.producer.handler.command.kafka

import cat.vonblum.chatogt.shared.domain.command.Command
import cat.vonblum.chatogt.shared.infrastructure.handler.command.CommandDispatcher

class KafkaCommandHandler(
    private val mapper: KafkaCommandMapper,
    private val dispatcher: CommandDispatcher
) {

    fun handle(command: Command) {
        // TODO
    }

}