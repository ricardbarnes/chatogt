package cat.vonblum.chatogt.usermanagement.users.update

import cat.vonblum.chatogt.usermanagement.domain.valueobject.IdFaker
import cat.vonblum.chatogt.usermanagement.domain.valueobject.StringFaker
import java.util.UUID

object UpdateUserNameCommandMother {

    fun create(
        id: UUID?,
        name: String?
    ): UpdateUserNameCommand = UpdateUserNameCommand(
        id ?: IdFaker.random(),
        name ?: StringFaker.name()
    )

}
