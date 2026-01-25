package cat.vonblum.chatogt.chat.chats

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import java.time.Instant
import java.util.*

class ChatDeletedEvent(
    aggregateId: UUID,
    aggregateVersion: Long,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now()
) : Event(
    aggregateId,
    aggregateVersion,
    id,
    occurredOn
)