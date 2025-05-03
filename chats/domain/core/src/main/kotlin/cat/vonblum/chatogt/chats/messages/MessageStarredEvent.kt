package cat.vonblum.chatogt.chats.messages

import cat.vonblum.chatogt.shared.domain.event.Event
import java.time.Instant
import java.util.*

class MessageStarredEvent(
    aggregateId: UUID,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now()
) : Event(aggregateId, id, occurredOn)