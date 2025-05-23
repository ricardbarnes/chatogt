package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.shared.roles.Role

class UserMother {

    companion object {

        fun create(
            id: UserId?,
            name: UserName?,
            password: UserPassword?,
            role: Role?,
            status: UserStatus?,
        ): User =
            User().apply {
                applyEvent(
                    UserCreatedEventMother.create(
                        id?.value,
                        name?.value,
                        password?.value,
                        role?.name,
                        status?.name
                    )
                )
            }
    }

}
