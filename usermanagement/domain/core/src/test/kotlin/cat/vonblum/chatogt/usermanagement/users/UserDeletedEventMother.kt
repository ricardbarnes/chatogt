package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.shared.domain.valueobject.IdFaker
import cat.vonblum.chatogt.shared.domain.valueobject.InstantFaker
import java.time.Instant
import java.util.UUID

object UserDeletedEventMother {

    fun create(
        aggregateId: UUID?,
        id: UUID?,
        occurredOn: Instant?,
    ) = UserDeletedEvent(
        aggregateId ?: IdFaker.random(),
        id ?: IdFaker.random(),
        occurredOn ?: InstantFaker.utcNow(),
    )

}
