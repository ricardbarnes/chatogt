package cat.vonblum.chatogt.usermanagement.api.bus.command.kafka

import cat.vonblum.chatogt.shared.domain.command.Command
import cat.vonblum.chatogt.shared.domain.command.CommandBus
import cat.vonblum.chatogt.shared.infrastructure.bus.command.kafka.KafkaUnsupportedCommandException
import cat.vonblum.chatogt.shared.infrastructure.io.message.Message
import cat.vonblum.chatogt.shared.infrastructure.io.message.MessageProducer
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import cat.vonblum.chatogt.usermanagement.users.delete.DeleteUserByIdCommand
import java.util.*

class KafkaCommandBus(private val producer: MessageProducer) : CommandBus {

    override fun dispatch(command: Command) {
        when (command) {
            is CreateUserCommand -> dispatchUserCommand(command)
            is DeleteUserByIdCommand -> dispatchUserCommand(command)
            else -> throw KafkaUnsupportedCommandException.becauseOf(command)
        }
    }

    private fun dispatchUserCommand(command: Command) {
        val envelope = Message(
            id = UUID.randomUUID(),
            aggregate = "users",
            type = "command",
            name = command::class.simpleName ?: "UnknownCommand",
            key = UUID.randomUUID().toString(),
            payload = command,
            metadata = mapOf(
                "source" to "user-management-api",
                "target" to "user-management-producer"
            )
        )
        producer.send(envelope)
    }

}
