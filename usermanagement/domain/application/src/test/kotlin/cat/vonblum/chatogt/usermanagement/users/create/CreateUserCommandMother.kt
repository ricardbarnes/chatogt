package cat.vonblum.chatogt.usermanagement.users.create

class CreateUserCommandMother {

    companion object {

        fun create(
            name: String?,
            password: String?,
            role: String?
        ): CreateUserCommand = CreateUserCommand(
            name ?: "defaultName",
            password ?: "defaultPassword",
            role ?: "USER"
        )

        fun random(): CreateUserCommand = create(
            null,
            null,
            null
        )

    }

}
