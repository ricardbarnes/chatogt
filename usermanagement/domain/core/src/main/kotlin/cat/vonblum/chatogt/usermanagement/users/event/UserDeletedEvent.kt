package cat.vonblum.chatogt.usermanagement.users.event

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import java.time.Instant
import java.util.UUID

class UserDeletedEvent(
    aggregateId: UUID,
    aggregateVersion: Long,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now(),
) : Event(
    aggregateId,
    aggregateVersion,
    id,
    occurredOn
)