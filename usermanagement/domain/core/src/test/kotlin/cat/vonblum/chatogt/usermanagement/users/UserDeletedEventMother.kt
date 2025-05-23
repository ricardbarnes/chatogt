package cat.vonblum.chatogt.usermanagement.users

import java.time.Instant
import java.util.UUID

class UserDeletedEventMother {

    companion object {

        fun create(
            aggregateId: UUID? = null,
            id: UUID? = null,
            occurredOn: Instant? = null,
        ) = UserDeletedEvent(
            aggregateId = aggregateId ?: UUID.randomUUID(),
            id = id ?: UUID.randomUUID(),
            occurredOn = occurredOn ?: Instant.now(),
        )

    }

}
