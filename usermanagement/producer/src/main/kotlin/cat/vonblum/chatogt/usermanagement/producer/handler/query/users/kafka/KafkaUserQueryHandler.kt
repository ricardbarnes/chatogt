package cat.vonblum.chatogt.usermanagement.producer.handler.query.users.kafka

import cat.vonblum.chatogt.shared.domain.query.Query
import cat.vonblum.chatogt.shared.infrastructure.handler.query.QueryDispatcher

class KafkaUserQueryHandler(
    private val mapper: KafkaUserQueryMapper,
    private val dispatcher: QueryDispatcher
) {

    fun handle(query: Query) {
        // TODO
    }

}