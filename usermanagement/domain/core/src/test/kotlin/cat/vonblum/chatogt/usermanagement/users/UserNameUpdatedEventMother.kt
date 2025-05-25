package cat.vonblum.chatogt.usermanagement.users

import java.time.Instant
import java.util.UUID

object UserNameUpdatedEventMother {

    fun create(
        aggregateId: UUID? = null,
        name: String? = null,
        id: UUID? = null,
        occurredOn: Instant? = null,
    ) = UserNameUpdatedEvent(
        aggregateId = aggregateId ?: UUID.randomUUID(),
        name = name ?: "defaultName",
        id = id ?: UUID.randomUUID(),
        occurredOn = occurredOn ?: Instant.now(),
    )

}
