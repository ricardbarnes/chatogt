package cat.vonblum.chatogt.usermanagement.users.event

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import java.time.Instant
import java.util.UUID

class UserCreatedEvent(
    aggregateId: UUID,
    aggregateVersion: Long,
    val email: String,
    val password: String,
    val type: String,
    val notificationTypes: Set<String>,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now(),
) : Event(
    aggregateId,
    aggregateVersion,
    id,
    occurredOn
)