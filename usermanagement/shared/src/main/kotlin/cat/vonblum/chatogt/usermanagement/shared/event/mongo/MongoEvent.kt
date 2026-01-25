package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
import java.util.UUID

@Document
abstract class MongoEvent(
    val eventId: UUID,
    val aggregateId: UUID,
    val version: Long,
    val eventType: String,
    val occurredOn: Instant
)