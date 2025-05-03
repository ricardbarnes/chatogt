package cat.vonblum.chatogt.chats.chats

import cat.vonblum.chatogt.shared.domain.event.Event
import java.time.Instant
import java.util.*

class ChatCreatedEvent(
    val participantIds: List<UUID>,
    aggregateId: UUID,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now()
) : Event(aggregateId, id, occurredOn)