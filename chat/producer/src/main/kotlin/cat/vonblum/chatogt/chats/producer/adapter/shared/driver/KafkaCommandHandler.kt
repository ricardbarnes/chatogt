package cat.vonblum.chatogt.chats.producer.adapter.shared.driver

import cat.vonblum.chatogt.chats.chats.create.CreateChatCommand
import cat.vonblum.chatogt.chats.chats.create.CreateChatCommandHandler
import cat.vonblum.chatogt.chats.messages.create.CreateMessageCommand
import cat.vonblum.chatogt.chats.messages.create.CreateMessageCommandHandler
import cat.vonblum.chatogt.chats.users.create.CreateUserCommand
import cat.vonblum.chatogt.chats.users.create.CreateUserCommandHandler
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.*

@Component
class KafkaCommandHandler(
    private val mapper: KafkaCommandMapper,
    private val createUserCommandHandler: CreateUserCommandHandler,
    private val createChatCommandHandler: CreateChatCommandHandler,
    private val createMessageCommandHandler: CreateMessageCommandHandler,
) {

    @KafkaListener(topics = ["\${kafka.topics.commands}"])
    fun handle(record: ConsumerRecord<UUID, String>) {
        val typeName = record.headers().lastHeader("type")?.value()?.let { String(it) }
        when (Class.forName(typeName).kotlin) {
            CreateUserCommand::class -> {
                val command = mapper.toDomain(record.value(), CreateUserCommand::class.java)
                createUserCommandHandler.handle(command)
            }

            CreateChatCommand::class -> {
                val command = mapper.toDomain(record.value(), CreateChatCommand::class.java)
                createChatCommandHandler.handle(command)
            }

            CreateMessageCommand::class -> {
                val command = mapper.toDomain(record.value(), CreateMessageCommand::class.java)
                createMessageCommandHandler.handle(command)
            }
        }
    }

}
