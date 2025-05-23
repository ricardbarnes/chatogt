package cat.vonblum.chatogt.usermanagement.users.create

class CreateUserCommandMother {

    companion object {

        fun create(
            name: String?,
            password: String?,
            role: String?
        ): CreateUserCommand = CreateUserCommand(
            name = name ?: "defaultName",
            password = password ?: "defaultPassword",
            role = role ?: "USER"
        )

        fun random(): CreateUserCommand = create(
            name = null,
            password = null,
            role = null
        )

    }

}
