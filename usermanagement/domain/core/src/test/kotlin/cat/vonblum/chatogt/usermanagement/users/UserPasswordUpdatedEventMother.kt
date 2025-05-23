package cat.vonblum.chatogt.usermanagement.users

import java.time.Instant
import java.util.UUID

class UserPasswordUpdatedEventMother {

    companion object {

        fun create(
            aggregateId: UUID? = null,
            password: String? = null,
            id: UUID? = null,
            occurredOn: Instant? = null,
        ) = UserPasswordUpdatedEvent(
            aggregateId = aggregateId ?: UUID.randomUUID(),
            password = password ?: "defaultPassword",
            id = id ?: UUID.randomUUID(),
            occurredOn = occurredOn ?: Instant.now(),
        )

    }

}
