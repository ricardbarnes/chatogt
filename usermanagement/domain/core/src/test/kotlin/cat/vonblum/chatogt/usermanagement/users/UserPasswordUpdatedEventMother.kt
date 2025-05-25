package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.shared.domain.valueobject.IdFaker
import cat.vonblum.chatogt.shared.domain.valueobject.InstantFaker
import cat.vonblum.chatogt.shared.domain.valueobject.StringFaker
import java.time.Instant
import java.util.UUID

object UserPasswordUpdatedEventMother {

    fun create(
        aggregateId: UUID?,
        password: String?,
        id: UUID?,
        occurredOn: Instant?,
    ) = UserPasswordUpdatedEvent(
        aggregateId ?: IdFaker.random(),
        password ?: StringFaker.password(),
        id ?: IdFaker.random(),
        occurredOn ?: InstantFaker.utcNow(),
    )

}
