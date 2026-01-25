package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import cat.vonblum.chatogt.usermanagement.shared.event.mongo.MongoEvent.Companion.USERS_COLLECTION
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.index.CompoundIndexes
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = USERS_COLLECTION)
@CompoundIndexes(
    CompoundIndex(
        name = "aggregateId_aggregateVersion_idx",
        def = "{'aggregateId': 1, 'aggregateVersion': 1}",
        unique = true
    )
)
class MongoUserCreatedEvent(
    id: String,
    aggregateId: String,
    aggregateVersion: Long,
    eventType: String,
    occurredOn: Instant,
    @Indexed(unique = true) val email: String,
    val password: String,
    val type: String,
    val notificationType: Set<String>
) : MongoEvent(
    id,
    aggregateId,
    aggregateVersion,
    eventType,
    occurredOn
)
