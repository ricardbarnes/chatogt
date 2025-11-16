package cat.vonblum.chatogt.chat.api.bus.shared.command.kafka

import cat.vonblum.chatogt.chat.chats.create.CreateChatCommand
import cat.vonblum.chatogt.chat.messages.create.CreateMessageCommand
import cat.vonblum.chatogt.chat.users.create.CreateUserCommand
import cat.vonblum.chatogt.shared.domain.command.Command
import cat.vonblum.chatogt.shared.domain.command.CommandBus
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.header.Headers
import org.apache.kafka.common.header.internals.RecordHeaders
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.UUID
import kotlin.reflect.KClass

@Component
class KafkaCommandBus(
    private val mapper: KafkaCommandMapper,
    private val producer: KafkaProducer<UUID, String>,
    @param:Value("\${kafka.topics.commands}") private val topic: String
) : CommandBus {

    override fun dispatch(command: Command) {
        when (command) {
            is CreateUserCommand -> handleDispatching(command)
            is CreateChatCommand -> handleDispatching(command)
            is CreateMessageCommand -> handleDispatching(command)
        }
    }

    private fun aHeaders(clazz: KClass<*>): Headers {
        val headers = RecordHeaders()
        headers.add("type", clazz.qualifiedName?.toByteArray())
        return headers
    }

    private fun handleDispatching(command: Command) {
        val record = ProducerRecord(
            topic,
            null,
            UUID.randomUUID(),
            mapper.toDto(command),
            aHeaders(command::class)
        )
        producer.send(record).get()
    }

}