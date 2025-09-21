package cat.vonblum.chatogt.usermanagement.producer.bus.event.kafka

import cat.vonblum.chatogt.shared.domain.event.Event
import cat.vonblum.chatogt.shared.domain.event.EventBus

class KafkaEventBus : EventBus {

    override fun publish(events: List<Event>) {
        TODO("Not yet implemented")
    }

}