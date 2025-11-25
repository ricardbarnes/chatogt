package cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka

import cat.vonblum.chatogt.usermanagement.domain.command.Command
import cat.vonblum.chatogt.usermanagement.infrastructure.handler.command.CommandDispatcher
import org.springframework.kafka.annotation.KafkaListener

class KafkaUserCommandHandler(
    private val mapper: KafkaUserCommandMapper,
    private val dispatcher: CommandDispatcher
) {

    @KafkaListener(
        topics = ["users.commands"],
        groupId = "user-management",
    )
    fun handle(command: Command) {
        // TODO
        println("Received command: $command")
    }

}