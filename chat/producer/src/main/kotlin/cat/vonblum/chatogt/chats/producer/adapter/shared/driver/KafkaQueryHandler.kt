package cat.vonblum.chatogt.chats.producer.adapter.shared.driver

import cat.vonblum.chatogt.chats.chats.find.FindChatIdsByUserIdQueryHandler
import cat.vonblum.chatogt.chats.chats.find.FindChatIdsByUserIdQuery
import cat.vonblum.chatogt.chats.chats.find.FindChatQuery
import cat.vonblum.chatogt.chats.chats.find.FindChatQueryHandler
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.header.internals.RecordHeaders
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.*

@Component
class KafkaQueryHandler(
    private val mapper: KafkaQueryMapper,
    private val findChatsByUserIdQuery: FindChatIdsByUserIdQueryHandler,
    private val findChatQueryHandler: FindChatQueryHandler,
    private val producer: KafkaProducer<UUID, String>,
    @Value("\${kafka.topics.responses}") private val responsesTopic: String
) {

    @KafkaListener(topics = ["\${kafka.topics.queries}"])
    fun handle(record: ConsumerRecord<UUID, String>) {
        val typeName = record.headers().lastHeader("type")?.value()?.let { String(it) }
        val type = Class.forName(typeName).kotlin
        val correlationId = record.headers().lastHeader("correlationId")?.value()

        when (type) {
            FindChatIdsByUserIdQuery::class -> {
                val response = findChatsByUserIdQuery.handle(mapper.toFindChatIdsByUserIdQuery(record.value()))
                val headers = RecordHeaders()
                headers.add("type", response::class.qualifiedName?.toByteArray())
                headers.add("correlationId", correlationId)
                val responseRecord = ProducerRecord(
                    responsesTopic,
                    null,
                    response.userId,
                    mapper.toDto(response),
                    headers
                )
                producer.send(responseRecord)
            }

            FindChatQuery::class -> {
                val response = findChatQueryHandler.handle(mapper.toFindChatQuery(record.value()))
                val headers = RecordHeaders()
                headers.add("type", response::class.qualifiedName?.toByteArray())
                headers.add("correlationId", correlationId)
                val responseRecord = ProducerRecord(
                    responsesTopic,
                    null,
                    response.id,
                    mapper.toDto(response),
                    headers
                )
                producer.send(responseRecord)
            }
        }

    }

}