package cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka

import cat.vonblum.chatogt.usermanagement.infrastructure.handler.command.CommandDispatcher
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import user.User

class KafkaUserCommandHandler(
    private val dispatcher: CommandDispatcher,
    private val mapper: KafkaUserCommandMapper,
) {

    @KafkaListener(
        topics = ["\${handler.commands.users.kafka.topic}"],
        groupId = "\${spring.kafka.consumer.group-id}",
    )
    fun handle(record: ConsumerRecord<String, ByteArray>) {
        val protoType = record.headers().lastHeader("proto.type")?.value()?.toString(Charsets.UTF_8)

        val message = when (protoType) {
            User.CreateUserRequest::class.java.simpleName -> User.CreateUserRequest.parseFrom(record.value())
            else -> error("Unknown proto type: $protoType")
        }

        println(message)
        // TODO...
    }

}