package cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka

import cat.vonblum.chatogt.usermanagement.domain.command.Command
import cat.vonblum.chatogt.usermanagement.domain.command.CommandHandler
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import user.User
import kotlin.reflect.KClass

class KafkaUserCommandHandler(
    private val handlerMap: Map<KClass<out Command>, CommandHandler>,
    private val mapper: KafkaUserCommandMapper,
) {

    @KafkaListener(
        topics = ["\${handler.commands.users.kafka.topic}"],
        groupId = "\${spring.kafka.consumer.group-id}",
    )
    fun handle(record: ConsumerRecord<String, ByteArray>) {
        when (
            val protoType = record.headers()
                .lastHeader("proto.type")
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
        // TODO
        println(command)
    }

}