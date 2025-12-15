package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.domain.valueobject.IdFaker
import cat.vonblum.chatogt.usermanagement.domain.valueobject.InstantFaker
import cat.vonblum.chatogt.usermanagement.domain.valueobject.StringFaker
import java.time.Instant
import java.util.*

object UserCreatedEventMother {

    fun create(
        aggregateId: UUID?,
        name: String?,
        password: String?,
        type: UserType?,
        id: UUID?,
        occurredOn: Instant?,
    ) = UserCreatedEvent(
        aggregateId ?: IdFaker.random(),
        name ?: StringFaker.name(),
        password ?: StringFaker.password(),
        type?.name ?: UserType.POOR.name,
        id ?: IdFaker.random(),
        occurredOn ?: InstantFaker.utcNow(),
    )

}
