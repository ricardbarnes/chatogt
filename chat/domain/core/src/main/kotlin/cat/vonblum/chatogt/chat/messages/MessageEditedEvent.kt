package cat.vonblum.chatogt.chat.messages

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import java.time.Instant
import java.util.*

class MessageEditedEvent(
    aggregateId: UUID,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now()
) : Event(aggregateId, id, occurredOn)