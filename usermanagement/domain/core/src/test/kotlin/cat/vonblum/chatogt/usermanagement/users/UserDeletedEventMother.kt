package cat.vonblum.chatogt.usermanagement.users

import java.time.Instant
import java.util.UUID

object UserDeletedEventMother {

    fun create(
        aggregateId: UUID?,
        id: UUID?,
        occurredOn: Instant?,
    ) = UserDeletedEvent(
        aggregateId ?: UUID.randomUUID(),
        id ?: UUID.randomUUID(),
        occurredOn ?: Instant.now(),
    )

}
