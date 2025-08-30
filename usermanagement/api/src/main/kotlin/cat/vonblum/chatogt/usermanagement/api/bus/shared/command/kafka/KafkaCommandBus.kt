package cat.vonblum.chatogt.usermanagement.api.bus.shared.command.kafka

import cat.vonblum.chatogt.shared.domain.command.Command
import cat.vonblum.chatogt.shared.domain.command.CommandBus
import cat.vonblum.chatogt.shared.infrastructure.bus.command.kafka.KafkaUnsupportedCommandException
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import cat.vonblum.chatogt.usermanagement.users.delete.DeleteUserByIdCommand
import org.springframework.stereotype.Component

@Component
class KafkaCommandBus : CommandBus {

    override fun dispatch(command: Command) {
        when (command) {
            is CreateUserCommand -> handleCreateUserCommand(command)
            is DeleteUserByIdCommand -> handleDeleteUserByIdCommand(command)
            else -> throw KafkaUnsupportedCommandException.becauseOf(command)
        }
    }

    private fun handleCreateUserCommand(command: CreateUserCommand) {
        // TODO
    }

    private fun handleDeleteUserByIdCommand(command: DeleteUserByIdCommand) {
        // TODO
    }

}