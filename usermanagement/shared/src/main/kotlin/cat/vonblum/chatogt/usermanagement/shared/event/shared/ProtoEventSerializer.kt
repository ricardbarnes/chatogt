package cat.vonblum.chatogt.usermanagement.shared.event.shared

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent
import user.User

class ProtoEventSerializer {

    fun serialize(event: Event): ByteArray =
        when (event) {
            is UserCreatedEvent -> toProto(event).toByteArray()
            else ->
                error("Unsupported event type: ${event::class}")
        }

    private fun toProto(event: UserCreatedEvent): User.UserCreatedEvent {
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

}
