package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.domain.aggregate.AggregateRehydrator
import java.util.UUID

object UserMother {

    fun create(
        id: UserId? = UserId(UUID.randomUUID()),
        name: UserEmail? = UserEmail("pepe@pepe.com"),
        password: UserPassword? = UserPassword("pepe"),
        type: UserType? = UserTypeMother.poor()
    ): User {
        val event = UserCreatedEventMother.create(
            id?.value,
            name?.value,
            password?.value,
            type,
            null,
            null
        )
        return AggregateRehydrator.apply(User::class, listOf(event))
    }

}
