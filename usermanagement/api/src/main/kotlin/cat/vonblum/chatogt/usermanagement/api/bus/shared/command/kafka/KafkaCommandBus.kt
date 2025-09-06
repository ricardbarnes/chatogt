package cat.vonblum.chatogt.usermanagement.api.bus.shared.command.kafka

import cat.vonblum.chatogt.shared.domain.command.Command
import cat.vonblum.chatogt.shared.domain.command.CommandBus
import cat.vonblum.chatogt.shared.infrastructure.bus.command.kafka.KafkaUnsupportedCommandException
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import cat.vonblum.chatogt.usermanagement.users.delete.DeleteUserByIdCommand
import org.springframework.kafka.core.KafkaTemplate
import java.util.*

class KafkaCommandBus( // TODO: finish
    private val template: KafkaTemplate<String, Command>,
    private val topics: Map<String, String>
) : CommandBus {

    override fun dispatch(command: Command) {
        when (command) {
            is CreateUserCommand -> handleUserCommand(command)
            is DeleteUserByIdCommand -> handleUserCommand(command)
            else -> throw KafkaUnsupportedCommandException.becauseOf(command)
        }
    }

    private fun handleUserCommand(command: Command) {
        template.send(
            topics.get("users"),
            UUID.randomUUID().toString(),
            command
        )
    }

}
