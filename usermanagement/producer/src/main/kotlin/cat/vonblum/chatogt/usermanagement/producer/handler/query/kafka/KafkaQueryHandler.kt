package cat.vonblum.chatogt.usermanagement.producer.handler.query.kafka

import cat.vonblum.chatogt.shared.infrastructure.bus.shared.MessageEnvelope
import cat.vonblum.chatogt.shared.infrastructure.handler.query.QueryDispatcher

class KafkaQueryHandler(
    private val mapper: KafkaQueryMapper,
    private val dispatcher: QueryDispatcher
) {

    fun handle(message: MessageEnvelope) {
        // TODO
    }

}