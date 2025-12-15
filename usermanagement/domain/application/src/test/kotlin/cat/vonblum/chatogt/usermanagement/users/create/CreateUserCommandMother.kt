package cat.vonblum.chatogt.usermanagement.users.create

import cat.vonblum.chatogt.usermanagement.domain.valueobject.StringFaker

object CreateUserCommandMother {

    fun create(
        name: String?,
        password: String?,
        type: String?
    ): CreateUserCommand = CreateUserCommand(
        name ?: StringFaker.name(),
        password ?: StringFaker.password(),
        type ?: "POOR"
    )

}
