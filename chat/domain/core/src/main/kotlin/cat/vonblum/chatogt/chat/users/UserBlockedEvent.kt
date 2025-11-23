package cat.vonblum.chatogt.chat.users

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import java.time.Instant
import java.util.UUID

class UserBlockedEvent(
    val blockedId: UUID,
    aggregateId: UUID,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now(),
) : Event(aggregateId, id, occurredOn)