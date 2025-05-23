package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.shared.domain.event.Event
import java.time.Instant
import java.util.UUID

class UserDeletedEvent(
    aggregateId: UUID,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now(),
) : Event(aggregateId, id, occurredOn)