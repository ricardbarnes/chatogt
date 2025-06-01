package cat.vonblum.chatogt.usermanagement.users.create

import cat.vonblum.chatogt.shared.domain.valueobject.StringFaker

object CreateUserCommandMother {

    fun create(
        name: String?,
        password: String?
    ): CreateUserCommand = CreateUserCommand(
        name ?: StringFaker.name(),
        password ?: StringFaker.password()
    )

    fun random(): CreateUserCommand = create(
        null,
        null
    )

}
