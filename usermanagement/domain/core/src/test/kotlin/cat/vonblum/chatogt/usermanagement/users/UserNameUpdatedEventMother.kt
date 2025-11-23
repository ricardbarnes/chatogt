package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.domain.valueobject.IdFaker
import cat.vonblum.chatogt.usermanagement.domain.valueobject.InstantFaker
import cat.vonblum.chatogt.usermanagement.domain.valueobject.StringFaker
import java.time.Instant
import java.util.UUID

object UserNameUpdatedEventMother {

    fun create(
        aggregateId: UUID?,
        name: String?,
        id: UUID?,
        occurredOn: Instant?,
    ) = UserNameUpdatedEvent(
        aggregateId ?: IdFaker.random(),
        name ?: StringFaker.name(),
        id ?: IdFaker.random(),
        occurredOn ?: InstantFaker.utcNow(),
    )

}
