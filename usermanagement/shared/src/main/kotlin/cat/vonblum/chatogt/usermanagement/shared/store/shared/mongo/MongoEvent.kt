package cat.vonblum.chatogt.usermanagement.shared.store.shared.mongo

import java.time.Instant
import java.util.UUID

class MongoEvent(
    val eventId: UUID,
    val aggregateId: UUID,
    val aggregateType: String,
    val version: Long,
    val eventType: String,
    val payload: ByteArray,
    val occurredAt: Instant
)