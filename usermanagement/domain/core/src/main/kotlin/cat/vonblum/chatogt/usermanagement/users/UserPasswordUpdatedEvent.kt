package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import java.time.Instant
import java.util.UUID

class UserPasswordUpdatedEvent(
    aggregateId: UUID,
    val password: String,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now(),
) : Event(aggregateId, id, occurredOn)