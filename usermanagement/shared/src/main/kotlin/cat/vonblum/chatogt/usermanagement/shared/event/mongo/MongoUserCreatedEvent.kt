package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import cat.vonblum.chatogt.usermanagement.shared.event.mongo.MongoEvent.Companion.USERS_COLLECTION
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = USERS_COLLECTION)
class MongoUserCreatedEvent(
    id: String,
    aggregateId: String,
    version: Long,
    eventType: String,
    occurredOn: Instant,
    @Indexed(unique = true) val email: String,
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
