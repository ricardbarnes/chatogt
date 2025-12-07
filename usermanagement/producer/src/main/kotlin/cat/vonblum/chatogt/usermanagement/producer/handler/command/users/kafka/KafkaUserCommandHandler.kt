package cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka

import cat.vonblum.chatogt.usermanagement.domain.command.CommandHandlerDispatcher
import cat.vonblum.chatogt.usermanagement.infrastructure.bus.shared.kafka.KafkaHeader
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import user.User

class KafkaUserCommandHandler(
    private val dispatcher: CommandHandlerDispatcher,
    private val mapper: KafkaUserCommandMapper,
) {

    @KafkaListener(
        topics = ["\${handler.commands.users.kafka.topic}"],
        groupId = "\${spring.kafka.consumer.group-id}",
    )
    fun handle(record: ConsumerRecord<String, ByteArray>) {
        when (
            val protoType = record.headers()
                .lastHeader(KafkaHeader.PROTO_TYPE)
                ?.value()
                ?.toString(Charsets.UTF_8)
        ) {
            User.CreateUserRequest::class.java.simpleName -> {
                val proto = User.CreateUserRequest.parseFrom(record.value())
                handle(proto)
            }

            else -> error("Unknown proto type: $protoType")
        }
    }

    private fun handle(createUserRequest: User.CreateUserRequest) {
        val command = mapper.toDomain(createUserRequest)
        dispatcher.dispatch(command)
    }

}