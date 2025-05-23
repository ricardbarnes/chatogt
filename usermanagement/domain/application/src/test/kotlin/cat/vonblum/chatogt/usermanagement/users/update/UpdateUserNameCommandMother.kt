package cat.vonblum.chatogt.usermanagement.users.update

import java.util.UUID

class UpdateUserNameCommandMother {

    companion object {

        fun create(
            id: UUID?,
            name: String?
        ): UpdateUserNameCommand = UpdateUserNameCommand(
            id = id ?: UUID.randomUUID(),
            name = name ?: "defaultName"
        )

    }

}
