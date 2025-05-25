package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.shared.domain.aggregate.AggregateEventRehydrator
import cat.vonblum.chatogt.usermanagement.shared.roles.Role

object UserMother {

    fun create(
        id: UserId? = UserIdMother.random(),
        name: UserName? = UserNameMother.random(),
        password: UserPassword? = UserPasswordMother.random(),
        role: Role? = Role.USER,
        status: UserStatus? = UserStatus.ACTIVE,
    ): User {
        val event = UserCreatedEventMother.create(
            id?.value,
            name?.value,
            password?.value,
            role?.name,
            status?.name
        )

        return AggregateEventRehydrator.rehydrate(User::class, listOf(event))
    }
}
