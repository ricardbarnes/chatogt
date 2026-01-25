package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import org.springframework.data.mongodb.core.index.Indexed
import java.time.Instant

abstract class MongoEvent(
    val id: String,
    val aggregateId: String,
    @Indexed(unique = true) val aggregateVersion: Long,
    val eventType: String,
    val occurredOn: Instant
) {

    companion object {

        const val USERS_COLLECTION = "users"

    }

}