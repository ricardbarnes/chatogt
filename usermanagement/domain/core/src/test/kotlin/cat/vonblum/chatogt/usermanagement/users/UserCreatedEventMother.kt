package cat.vonblum.chatogt.usermanagement.users

import java.time.Instant
import java.util.UUID

object UserCreatedEventMother {

    fun create(
        aggregateId: UUID? = null,
        name: String? = null,
        password: String? = null,
        id: UUID? = null,
        occurredOn: Instant? = null,
    ) = UserCreatedEvent(
        aggregateId ?: UUID.randomUUID(),
        name ?: "defaultName",
        password ?: "defaultPassword",
        id ?: UUID.randomUUID(),
        occurredOn ?: Instant.now(),
    )

}
