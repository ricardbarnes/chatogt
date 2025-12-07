package cat.vonblum.chatogt.usermanagement.producer.bus.event.kafka

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.shared.config.spring.SpringBusProps
import org.springframework.kafka.core.KafkaTemplate

class KafkaEventBus(
    private val template: KafkaTemplate<String, ByteArray>,
    private val mapper: KafkaEventMapper,
    private val props: SpringBusProps
) : EventBus {

    override fun publish(events: List<Event>) {
        // TODO
        println(events)
    }

}