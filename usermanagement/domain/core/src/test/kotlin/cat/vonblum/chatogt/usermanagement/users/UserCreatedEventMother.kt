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
        notificationType: UserNotificationType?,
        id: UUID?,
        occurredOn: Instant?,
    ) = UserCreatedEvent(
        aggregateId ?: IdFaker.random(),
        name ?: StringFaker.name(),
        password ?: StringFaker.password(),
        type?.name ?: UserType.STANDARD.name,
        setOf(notificationType?.name ?: UserNotificationType.EMAIL.name),
        id ?: IdFaker.random(),
        occurredOn ?: InstantFaker.utcNow(),
    )

}
