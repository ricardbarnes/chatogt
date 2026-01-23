package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
import java.util.UUID

@Document
abstract class MongoEvent(
    open val eventId: UUID,
    open val aggregateId: UUID,
    open val version: Long,
    open val eventType: String,
    open val occurredOn: Instant
)