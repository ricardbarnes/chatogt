package cat.vonblum.chatogt.usermanagement.users.create

class CreateUserCommandMother {

    companion object {

        fun create(
            name: String?,
            password: String?
        ): CreateUserCommand = CreateUserCommand(
            name ?: "defaultName",
            password ?: "defaultPassword"
        )

        fun random(): CreateUserCommand = create(
            null,
            null
        )

    }

}
