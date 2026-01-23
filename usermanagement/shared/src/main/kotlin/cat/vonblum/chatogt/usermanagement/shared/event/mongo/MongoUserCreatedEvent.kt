package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import java.time.Instant
import java.util.UUID

class MongoUserCreatedEvent(
    eventId: UUID,
    aggregateId: UUID,
    version: Long,
    eventType: String,
    occurredOn: Instant,
    email: String,
    password: String,
    type: String,
    notificationType: Set<String>
) : MongoEvent(
    eventId,
    aggregateId,
    version,
    eventType,
    occurredOn
)