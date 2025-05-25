package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.shared.domain.valueobject.IdFaker
import cat.vonblum.chatogt.shared.domain.valueobject.InstantFaker
import cat.vonblum.chatogt.shared.domain.valueobject.StringFaker
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
        aggregateId ?: IdFaker.random(),
        name ?: StringFaker.name(),
        password ?: StringFaker.password(),
        id ?: IdFaker.random(),
        occurredOn ?: InstantFaker.utcNow(),
    )

}
