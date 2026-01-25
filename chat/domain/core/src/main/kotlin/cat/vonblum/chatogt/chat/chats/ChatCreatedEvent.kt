package cat.vonblum.chatogt.chat.chats

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import java.time.Instant
import java.util.*

class ChatCreatedEvent(
    aggregateId: UUID,
    val participantIds: List<UUID>,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now()
) : Event(
    aggregateId,
    0,
    id,
    occurredOn
)