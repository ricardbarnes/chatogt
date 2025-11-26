package cat.vonblum.chatogt.usermanagement.api.bus.command.spring

import cat.vonblum.chatogt.usermanagement.infrastructure.io.message.Message
import cat.vonblum.chatogt.usermanagement.infrastructure.io.message.MessageProducer
import cat.vonblum.chatogt.usermanagement.api.bus.command.kafka.KafkaCommandMapper
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import cat.vonblum.chatogt.usermanagement.users.delete.DeleteUserByIdCommand
import cat.vonblum.chatogt.usermanagement.users.update.UpdateUserPasswordCommand
import org.springframework.kafka.core.KafkaTemplate

class SpringKafkaMessageProducer(
    private val template: KafkaTemplate<String, ByteArray>,
    private val topicResolver: (Message) -> String,
    private val mapper: KafkaCommandMapper
) : MessageProducer {

    override fun send(message: Message) {
        val topic = topicResolver(message)
        val payload = map(message.payload)
        template.send(
            topic,
            message.key,
            payload
        )
    }

    fun map(payload: Any): ByteArray {
        return when (val kClass = payload::class) {
            CreateUserCommand::class -> mapper.toInfra(payload as CreateUserCommand)
            DeleteUserByIdCommand::class -> mapper.toInfra(payload as DeleteUserByIdCommand)
            UpdateUserPasswordCommand::class -> mapper.toInfra(payload as UpdateUserPasswordCommand)
            else -> throw IllegalArgumentException("$kClass is not supported")
        }
    }

}