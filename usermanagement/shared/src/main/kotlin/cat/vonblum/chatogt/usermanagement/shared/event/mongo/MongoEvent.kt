package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import java.time.Instant
import java.util.UUID

abstract class MongoEvent(
    val eventId: UUID,
    val aggregateId: UUID,
    val aggregateType: String,
    val version: Long,
    val eventType: String,
    val payload: ByteArray,
    val occurredAt: Instant
)