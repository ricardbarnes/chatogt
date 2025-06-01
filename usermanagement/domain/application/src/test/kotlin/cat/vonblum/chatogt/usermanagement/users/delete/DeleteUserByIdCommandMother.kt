package cat.vonblum.chatogt.usermanagement.users.delete

import cat.vonblum.chatogt.shared.domain.valueobject.IdFaker
import java.util.UUID

object DeleteUserByIdCommandMother {

    fun create(id: UUID?): DeleteUserByIdCommand =
        DeleteUserByIdCommand(id ?: IdFaker.random())

    fun random(): DeleteUserByIdCommand = create(null)

}
