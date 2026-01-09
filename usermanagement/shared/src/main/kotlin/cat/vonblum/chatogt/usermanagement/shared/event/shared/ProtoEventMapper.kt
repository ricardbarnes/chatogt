package cat.vonblum.chatogt.usermanagement.shared.event.shared

import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent
import user.User
import java.time.Instant
import java.util.UUID

class ProtoEventMapper {

    fun toInfra(event: UserCreatedEvent): User.UserCreatedEvent {
        return User.UserCreatedEvent.newBuilder()
            .setAggregateId(event.aggregateId.toString())
            .setEmail(event.email)
            .setPassword(event.password)
            .setType(event.type)
            .addAllNotificationTypes(event.notificationTypes)
            .setId(event.id.toString())
            .setOccurredOn(event.occurredOn.toString())
            .build()
    }

    fun deserializeUserCreatedEvent(payload: ByteArray): UserCreatedEvent {
        val proto = User.UserCreatedEvent.parseFrom(payload)
        return UserCreatedEvent(
            UUID.fromString(proto.aggregateId),
            proto.email,
            proto.password,
            proto.type,
            proto.notificationTypesList.toSet(),
            UUID.fromString(proto.id),
            Instant.parse(proto.occurredOn)
        )
    }

}
