package cat.vonblum.chatogt.usermanagement.users.delete

import cat.vonblum.chatogt.shared.domain.valueobject.IdFaker
import java.util.UUID

class DeleteUserByIdCommandMother {

    companion object {

        fun create(id: UUID?): DeleteUserByIdCommand =
            DeleteUserByIdCommand(id ?: IdFaker.random())

    }

}
