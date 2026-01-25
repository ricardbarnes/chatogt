package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent

class MongoEventMapper {

    fun toInfra(event: UserCreatedEvent): MongoUserCreatedEvent {
        return MongoUserCreatedEvent(
            event.id,
            event.aggregateId,
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
            event.aggregateId,
            event.version,
            event.email,
            event.password,
            event.eventType,
            event.notificationType,
            event.eventId,
            event.occurredOn
        )
    }

}