package cat.vonblum.chatogt.usermanagement.producer.handler.query.users.kafka

import cat.vonblum.chatogt.usermanagement.domain.query.Query
import cat.vonblum.chatogt.usermanagement.infrastructure.handler.query.QueryDispatcher

class KafkaUserQueryHandler(
    private val mapper: KafkaUserQueryMapper,
    private val dispatcher: QueryDispatcher
) {

    fun handle(query: Query) {
        // TODO
    }

}