package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.shared.domain.event.Event
import java.time.Instant
import java.util.UUID

class UserCreatedEvent(
    aggregateId: UUID,
    val name: String,
    val password: String,
    val role: String,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now(),
) : Event(aggregateId, id, occurredOn)