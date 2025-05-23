package cat.vonblum.chatogt.usermanagement.users

import java.time.Instant
import java.util.UUID

class UserCreatedEventMother {

    companion object {

        fun create(
            aggregateId: UUID? = null,
            name: String? = null,
            password: String? = null,
            role: String? = null,
            status: String? = null,
            id: UUID? = null,
            occurredOn: Instant? = null,
        ) = UserCreatedEvent(
            aggregateId = aggregateId ?: UUID.randomUUID(),
            name = name ?: "defaultName",
            password = password ?: "defaultPassword",
            role = role ?: "USER",
            status = status ?: "ACTIVE",
            id = id ?: UUID.randomUUID(),
            occurredOn = occurredOn ?: Instant.now(),
        )

    }

}
