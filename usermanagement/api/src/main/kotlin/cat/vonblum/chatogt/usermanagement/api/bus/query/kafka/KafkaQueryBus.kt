package cat.vonblum.chatogt.usermanagement.api.bus.query.kafka

import cat.vonblum.chatogt.usermanagement.domain.query.Query
import cat.vonblum.chatogt.usermanagement.domain.query.QueryBus
import cat.vonblum.chatogt.usermanagement.domain.query.Response
import cat.vonblum.chatogt.usermanagement.infrastructure.bus.query.kafka.KafkaUnsupportedQueryException
import cat.vonblum.chatogt.usermanagement.shared.config.spring.SpringBusProps
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByEmailQuery
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByIdQuery
import org.springframework.kafka.core.KafkaTemplate

class KafkaQueryBus(
    kafkaTemplate: KafkaTemplate<String, ByteArray>,
    // TODO
    props: SpringBusProps
) : QueryBus {

    override fun ask(query: Query): Response {
        return when (query) {
            is FindUserByIdQuery -> askUserQuery(query)
            is FindUserByEmailQuery -> askUserQuery(query)
            else -> throw KafkaUnsupportedQueryException.becauseOf(query)
        }
    }

    private fun askUserQuery(query: Query): Response {
        TODO()
    }

}
