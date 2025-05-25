package cat.vonblum.chatogt.usermanagement.users

import java.time.Instant
import java.util.UUID

object UserPasswordUpdatedEventMother {

    fun create(
        aggregateId: UUID?,
        password: String?,
        id: UUID?,
        occurredOn: Instant?,
    ) = UserPasswordUpdatedEvent(
        aggregateId ?: UUID.randomUUID(),
        password ?: "defaultPassword",
        id ?: UUID.randomUUID(),
        occurredOn ?: Instant.now(),
    )

}
