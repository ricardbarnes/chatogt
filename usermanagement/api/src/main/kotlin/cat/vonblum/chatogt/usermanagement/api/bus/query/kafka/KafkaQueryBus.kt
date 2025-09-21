package cat.vonblum.chatogt.usermanagement.api.bus.query.kafka

import cat.vonblum.chatogt.shared.domain.query.Query
import cat.vonblum.chatogt.shared.domain.query.QueryBus
import cat.vonblum.chatogt.shared.domain.query.Response
import cat.vonblum.chatogt.shared.infrastructure.bus.shared.Message
import cat.vonblum.chatogt.shared.infrastructure.bus.shared.MessageProducer
import cat.vonblum.chatogt.shared.infrastructure.bus.query.kafka.KafkaUnsupportedQueryException
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByIdQuery
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByNameQuery
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit

class KafkaQueryBus(private val producer: MessageProducer) : QueryBus {

    // Map to correlate envelope keys with responses
    private val responseMap = ConcurrentHashMap<String, CompletableFuture<Response>>()

    override fun ask(query: Query): Response {
        return when (query) {
            is FindUserByIdQuery -> askUserQuery(query)
            is FindUserByNameQuery -> askUserQuery(query)
            else -> throw KafkaUnsupportedQueryException.becauseOf(query)
        }
    }

    private fun askUserQuery(query: Query): Response {
        val key = UUID.randomUUID().toString()
        val envelope = Message(
            id = UUID.randomUUID(),
            aggregate = "users",
            type = "query",
            name = query::class.simpleName ?: "UnknownQuery",
            key = key,
            payload = query,
            metadata = mapOf(
                "source" to "user-management-api",
                "target" to "user-management-producer"
            )
        )

        // Prepare a future to wait for the response
        val future = CompletableFuture<Response>()
        responseMap[key] = future

        // Send the query
        producer.send(envelope)

        // Wait for the response (timeout example: 5 seconds)
        return try {
            future.get(5, TimeUnit.SECONDS)
        } finally {
            responseMap.remove(key)
        }
    }

}
