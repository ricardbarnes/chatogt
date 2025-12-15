package cat.vonblum.chatogt.usermanagement.producer.bus.event.kafka

import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent
import user.User

class KafkaEventMapper {

    fun toInfra(event: UserCreatedEvent): ByteArray {
        return User.UserCreatedEvent.newBuilder()
            .setEmail(event.email)
            .setPassword(event.password)
            .setType(event.type)
            .build()
            .toByteArray()
    }

}