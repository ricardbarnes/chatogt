package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import java.time.Instant
import java.util.UUID

class UserPasswordUpdatedEvent(
    aggregateId: UUID,
    aggregateVersion: Long,
    val password: String,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now(),
) : Event(
    aggregateId,
    aggregateVersion,
    id,
    occurredOn
)