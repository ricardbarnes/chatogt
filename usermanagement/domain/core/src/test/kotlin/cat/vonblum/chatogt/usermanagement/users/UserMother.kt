package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.shared.domain.aggregate.AggregateEventRehydrator

object UserMother {

    fun create(
        id: UserId? = UserIdMother.random(),
        name: UserName? = UserNameMother.random(),
        password: UserPassword? = UserPasswordMother.random(),
    ): User {
        val event = UserCreatedEventMother.create(
            id?.value,
            name?.value,
            password?.value,
        )
        return AggregateEventRehydrator.rehydrate(User::class, listOf(event))
    }

}
