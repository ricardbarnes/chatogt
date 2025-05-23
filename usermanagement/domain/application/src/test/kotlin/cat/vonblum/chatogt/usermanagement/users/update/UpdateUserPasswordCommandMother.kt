package cat.vonblum.chatogt.usermanagement.users.update

import java.util.UUID

class UpdateUserPasswordCommandMother {

    companion object {

        fun create(
            id: UUID?,
            password: String?
        ): UpdateUserPasswordCommand = UpdateUserPasswordCommand(
            id = id ?: UUID.randomUUID(),
            password = password ?: "defaultPassword"
        )

    }

}
