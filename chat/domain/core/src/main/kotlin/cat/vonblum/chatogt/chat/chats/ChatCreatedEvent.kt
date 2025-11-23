package cat.vonblum.chatogt.chat.chats

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import java.time.Instant
import java.util.*

class ChatCreatedEvent(
    val participantIds: List<UUID>,
    aggregateId: UUID,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now()
) : Event(aggregateId, id, occurredOn)