package cat.vonblum.chatogt.usermanagement.users

import java.time.Instant
import java.util.UUID

object UserPasswordUpdatedEventMother {

    fun create(
        aggregateId: UUID? = null,
        password: String? = null,
        id: UUID? = null,
        occurredOn: Instant? = null,
    ) = UserPasswordUpdatedEvent(
        aggregateId ?: UUID.randomUUID(),
        password ?: "defaultPassword",
        id ?: UUID.randomUUID(),
        occurredOn ?: Instant.now(),
    )

}
