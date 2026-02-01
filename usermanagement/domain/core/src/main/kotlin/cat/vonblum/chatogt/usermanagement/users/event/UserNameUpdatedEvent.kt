package cat.vonblum.chatogt.usermanagement.users.event

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import java.time.Instant
import java.util.UUID

class UserNameUpdatedEvent(
    aggregateId: UUID,
    aggregateVersion: Long,
    val name: String,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now(),
) : Event(
    aggregateId,
    aggregateVersion,
    id,
    occurredOn
)