package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import java.time.Instant

class MongoUserCreatedEvent(
    id: String,
    aggregateId: String,
    version: Long,
    eventType: String,
    occurredOn: Instant,
    val email: String,
    val password: String,
    val type: String,
    val notificationType: Set<String>
) : MongoEvent(
    id,
    aggregateId,
    version,
    eventType,
    occurredOn
)
