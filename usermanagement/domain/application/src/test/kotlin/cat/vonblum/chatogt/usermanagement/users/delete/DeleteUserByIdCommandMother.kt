package cat.vonblum.chatogt.usermanagement.users.delete

import java.util.UUID

class DeleteUserByIdCommandMother {

    companion object {

        fun create(id: UUID?): DeleteUserByIdCommand =
            DeleteUserByIdCommand(id ?: UUID.randomUUID())

    }

}
