package cat.vonblum.chatogt.usermanagement.api.bus.shared.command.kafka

import cat.vonblum.chatogt.shared.domain.command.Command
import cat.vonblum.chatogt.shared.domain.command.CommandBus
import cat.vonblum.chatogt.shared.infrastructure.bus.command.kafka.KafkaUnsupportedCommandException
import cat.vonblum.chatogt.shared.infrastructure.bus.command.shared.MessageEnvelope
import cat.vonblum.chatogt.shared.infrastructure.bus.command.shared.MessageProducer
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import cat.vonblum.chatogt.usermanagement.users.delete.DeleteUserByIdCommand
import java.util.*

class KafkaCommandBus(private val producer: MessageProducer) : CommandBus {

    override fun dispatch(command: Command) {
        when (command) {
            is CreateUserCommand -> dispatchUserCommand(command)
            is DeleteUserByIdCommand -> dispatchUserCommand(command)
            // add further commands upon here
            else -> throw KafkaUnsupportedCommandException.becauseOf(command)
        }
    }

    private fun dispatchUserCommand(command: Command) {
        val envelope = MessageEnvelope(
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

    // add further command dispatcher methods (for new aggregates) upon here

}
