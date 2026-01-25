package cat.vonblum.chatogt.chat.users

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import java.time.Instant
import java.util.UUID

class UserBlockedEvent(
    aggregateId: UUID,
    aggregateVersion: Long,
    val blockedId: UUID,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now(),
) : Event(
    aggregateId,
    aggregateVersion,
    id,
    occurredOn
)