package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import java.time.Instant
import java.util.UUID

class MongoUserCreatedEvent(
    eventId: UUID,
    aggregateId: UUID,
    version: Long,
    eventType: String,
    occurredOn: Instant,
    val email: String,
    val password: String,
    val type: String,
    val notificationType: Set<String>
) : MongoEvent(
    eventId,
    aggregateId,
    version,
    eventType,
    occurredOn
)
