package cat.vonblum.chatogt.usermanagement.api.bus.shared.query.kafka

import cat.vonblum.chatogt.shared.domain.query.Query
import cat.vonblum.chatogt.shared.domain.query.QueryBus
import cat.vonblum.chatogt.shared.domain.query.Response
import cat.vonblum.chatogt.shared.infrastructure.bus.query.kafka.KafkaUnsupportedQueryException
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByIdQuery
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByNameQuery
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByNameResponse
import org.springframework.stereotype.Component

@Component
class KafkaQueryBus : QueryBus {

    override fun ask(query: Query): Response {
        when (query) {
            is FindUserByIdQuery -> handleFindUserByIdQuery(query)
            is FindUserByNameQuery -> handleFindUserByNameQuery(query)
        }

        throw KafkaUnsupportedQueryException.becauseOf(query)
    }

    private fun handleFindUserByIdQuery(query: FindUserByIdQuery): FindUserByNameResponse {
        TODO("Not yet implemented")
    }

    private fun handleFindUserByNameQuery(query: FindUserByNameQuery): FindUserByNameResponse {
        TODO("Not yet implemented")
    }

}