package cat.vonblum.chatogt.usermanagement.shared.event.shared

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.shared.event.mongo.MongoEvent
import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent
import user.User
import java.time.Instant
import java.util.UUID

class ProtoEventDeserializer {

    fun deserialize(event: MongoEvent): Event =
        when (event.eventType) {
            UserCreatedEvent::class.qualifiedName -> toEvent(event.payload)
            else ->
                error("Unknown event type ${event.eventType}")
        }

    private fun toEvent(payload: ByteArray): UserCreatedEvent {
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
