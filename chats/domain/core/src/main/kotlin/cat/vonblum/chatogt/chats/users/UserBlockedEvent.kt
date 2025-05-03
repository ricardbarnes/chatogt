package cat.vonblum.chatogt.chats.users

import cat.vonblum.chatogt.shared.domain.event.Event
import java.time.Instant
import java.util.UUID

class UserBlockedEvent(
    val blockedId: UUID,
    aggregateId: UUID,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now(),
) : Event(aggregateId, id, occurredOn)