package cat.vonblum.chatogt.chat.users

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import java.time.Instant
import java.util.UUID

class UserCreatedEvent(
    aggregateId: UUID,
    val name: String,
    val password: String,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now(),
) : Event(aggregateId, id, occurredOn)