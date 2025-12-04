package cat.vonblum.chatogt.usermanagement.api.bus.command.kafka

import cat.vonblum.chatogt.usermanagement.api.config.shared.spring.SpringBusProps
import cat.vonblum.chatogt.usermanagement.domain.command.Command
import cat.vonblum.chatogt.usermanagement.domain.command.CommandBus
import cat.vonblum.chatogt.usermanagement.infrastructure.bus.command.kafka.KafkaUnsupportedCommandException
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import org.springframework.kafka.core.KafkaTemplate
import java.util.*

class KafkaCommandBus(
    private val template: KafkaTemplate<String, ByteArray>,
    private val mapper: KafkaCommandMapper,
    private val props: SpringBusProps
) : CommandBus {

    override fun dispatch(command: Command) {
        when (command) {
            is CreateUserCommand -> dispatchUserCommand(command)
            // TODO
            else -> throw KafkaUnsupportedCommandException.becauseOf(command)
        }
    }

    private fun dispatchUserCommand(command: CreateUserCommand) {
        val topic = props.commands["users"]?.kafka?.topic
        val payload = mapper.toInfra(command)
        if (topic != null) {
            template.send(
                topic,
                UUID.randomUUID().toString(),
                payload
            )
        }
    }

}
