package cat.vonblum.chatogt.usermanagement.users

import java.time.Instant
import java.util.UUID

object UserNameUpdatedEventMother {

    fun create(
        aggregateId: UUID?,
        name: String?,
        id: UUID?,
        occurredOn: Instant?,
    ) = UserNameUpdatedEvent(
        aggregateId = aggregateId ?: UUID.randomUUID(),
        name = name ?: "defaultName",
        id = id ?: UUID.randomUUID(),
        occurredOn = occurredOn ?: Instant.now(),
    )

}
