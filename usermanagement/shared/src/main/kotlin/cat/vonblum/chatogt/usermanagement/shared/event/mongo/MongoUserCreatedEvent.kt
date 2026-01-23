package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import java.time.Instant
import java.util.UUID

class MongoUserCreatedEvent(
    override val eventId: UUID,
    override val aggregateId: UUID,
    override val version: Long,
    override val eventType: String,
    override val occurredOn: Instant,
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
