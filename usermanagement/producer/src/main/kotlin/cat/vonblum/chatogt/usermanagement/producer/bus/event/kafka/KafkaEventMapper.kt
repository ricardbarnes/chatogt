package cat.vonblum.chatogt.usermanagement.producer.bus.event.kafka

import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent

class KafkaEventMapper {

    fun toInfra(event: UserCreatedEvent): ByteArray {
        TODO()
    }

}