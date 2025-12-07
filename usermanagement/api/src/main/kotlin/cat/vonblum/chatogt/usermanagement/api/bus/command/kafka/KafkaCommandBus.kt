package cat.vonblum.chatogt.usermanagement.api.bus.command.kafka

import cat.vonblum.chatogt.usermanagement.api.config.shared.spring.SpringBusProps
import cat.vonblum.chatogt.usermanagement.domain.command.Command
import cat.vonblum.chatogt.usermanagement.domain.command.CommandBus
import cat.vonblum.chatogt.usermanagement.infrastructure.bus.command.kafka.KafkaUnsupportedCommandException
import cat.vonblum.chatogt.usermanagement.infrastructure.bus.shared.kafka.KafkaHeader
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.header.internals.RecordHeader
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import user.User
import java.util.*

class KafkaCommandBus(
    private val template: KafkaTemplate<String, ByteArray>,
    private val mapper: KafkaCommandMapper,
    private val props: SpringBusProps
) : CommandBus {

    override fun dispatch(command: Command) {
        when (command) {
            is CreateUserCommand -> dispatchUserCommand(command)
            else -> throw KafkaUnsupportedCommandException.becauseOf(command)
        }
    }

    private fun dispatchUserCommand(command: CreateUserCommand) {
        val topic = props.commands["users"]?.kafka?.topic ?: throw KafkaUnsupportedCommandException.becauseOf(command)
        val payload = mapper.toInfra(command)
        val record = ProducerRecord(
            topic,
            UUID.randomUUID().toString(),
            payload
        ).apply {
            headers().add(
                RecordHeader(
                    KafkaHeader.PROTO_TYPE,
                    User.CreateUserRequest::class.java.simpleName.toByteArray()
                )
            )
        }

        template.send(record)
    }

}
