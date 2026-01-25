package cat.vonblum.chatogt.usermanagement.consumer.handler.users.kafka

import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent
import user.User
import java.util.UUID

class KafkaUserEventMapper {

    fun toDomain(event: User.UserCreatedEvent): UserCreatedEvent {
        return UserCreatedEvent(
            UUID.fromString(event.id),
            event.aggregateVersion,
            event.email,
            event.password,
            event.type,
            event.notificationTypesList.toSet(),
        )
    }

}