package cat.vonblum.chatogt.usermanagement.users

import java.time.Instant
import java.util.*

object UserCreatedEventMother {

    fun create(
        aggregateId: UUID?,
        name: String?,
        password: String?,
        id: UUID?,
        occurredOn: Instant?,
    ) = UserCreatedEvent(
        aggregateId ?: UUID.randomUUID(),
        name ?: "defaultName",
        password ?: "defaultPassword",
        id ?: UUID.randomUUID(),
        occurredOn ?: Instant.now(),
    )

}
