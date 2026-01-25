package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document
abstract class MongoEvent(
    val id: String,
    val aggregateId: String,
    val version: Long,
    val eventType: String,
    val occurredOn: Instant
)