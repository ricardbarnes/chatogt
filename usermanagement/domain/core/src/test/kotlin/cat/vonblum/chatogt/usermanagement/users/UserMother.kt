package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.domain.aggregate.AggregateRehydrator

object UserMother {

    fun create(
        id: UserId? = UserIdMother.random(),
        name: UserEmail? = UserEmailMother.random(),
        password: UserPassword? = UserPasswordMother.random(),
    ): User {
        val event = UserCreatedEventMother.create(
            id?.value,
            name?.value,
            password?.value,
            null,
            null
        )
        return AggregateRehydrator.apply(User::class, listOf(event))
    }

}
