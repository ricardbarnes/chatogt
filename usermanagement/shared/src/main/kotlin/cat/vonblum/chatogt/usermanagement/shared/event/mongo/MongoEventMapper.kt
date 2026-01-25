package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent
import java.util.UUID

class MongoEventMapper {

    fun toInfra(event: UserCreatedEvent): MongoUserCreatedEvent {
        return MongoUserCreatedEvent(
            event.id.toString(),
            event.aggregateId.toString(),
            event.aggregateVersion,
            event.javaClass.simpleName,
            event.occurredOn,
            event.email,
            event.password,
            event.type,
            event.notificationTypes
        )
    }

    fun toDomain(event: MongoUserCreatedEvent): UserCreatedEvent {
        return UserCreatedEvent(
            UUID.fromString(event.aggregateId),
            event.aggregateVersion,
            event.email,
            event.password,
            event.eventType,
            event.notificationType,
            UUID.fromString(event.id),
            event.occurredOn
        )
    }

}