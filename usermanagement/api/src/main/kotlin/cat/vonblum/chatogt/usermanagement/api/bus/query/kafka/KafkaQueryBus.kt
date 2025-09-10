package cat.vonblum.chatogt.usermanagement.api.bus.query.kafka

import cat.vonblum.chatogt.shared.domain.query.Query
import cat.vonblum.chatogt.shared.domain.query.QueryBus
import cat.vonblum.chatogt.shared.domain.query.Response
import cat.vonblum.chatogt.shared.infrastructure.bus.MessageEnvelope
import cat.vonblum.chatogt.shared.infrastructure.bus.command.MessageProducer
import cat.vonblum.chatogt.shared.infrastructure.bus.query.kafka.KafkaUnsupportedQueryException
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByIdQuery
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByNameQuery
import java.util.*

class KafkaQueryBus(private val producer: MessageProducer) : QueryBus {

    override fun ask(query: Query): Response {
        return when (query) {
            is FindUserByIdQuery -> askUserQuery(query)
            is FindUserByNameQuery -> askUserQuery(query)
            // add further queries upon here
            else -> throw KafkaUnsupportedQueryException.becauseOf(query)
        }
    }

    private fun askUserQuery(query: Query): Response {
        val envelope = MessageEnvelope(
            id = UUID.randomUUID(),
            aggregate = "users",
            type = "query",
            name = query::class.simpleName ?: "UnknownQuery",
            key = UUID.randomUUID().toString(),
            payload = query,
            metadata = mapOf(
                "source" to "user-management-api",
                "target" to "user-management-producer"
            )
        )
        producer.send(envelope)

        // In a real implementation, you’d need to wait for a correlated response,
        // likely by consuming from a Kafka reply topic using the envelope key.
        // For now, this is just a placeholder:
        TODO()
    }

    // add further query dispatcher methods (for new aggregates) upon here

}
