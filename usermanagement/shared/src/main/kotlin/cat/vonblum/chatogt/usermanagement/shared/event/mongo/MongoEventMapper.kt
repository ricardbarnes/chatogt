package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent

class MongoEventMapper {

    fun toInfra(event: UserCreatedEvent, version: Long): MongoUserCreatedEvent {
        return MongoUserCreatedEvent(
            event.id,
            event.aggregateId,
            version,
            event.javaClass.simpleName,
            event.occurredOn,
            event.email,
            event.password,
            event.type,
            event.notificationTypes
        )
    }

}