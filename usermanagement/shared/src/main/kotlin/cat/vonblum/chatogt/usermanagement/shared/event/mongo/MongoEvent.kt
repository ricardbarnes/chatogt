package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import java.time.Instant

abstract class MongoEvent(
    val id: String,
    val aggregateId: String,
    val aggregateVersion: Long,
    val eventType: String,
    val occurredOn: Instant
) {

    companion object {

        const val USERS_COLLECTION = "users"

    }

}