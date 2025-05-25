package cat.vonblum.chatogt.usermanagement.users.update

import cat.vonblum.chatogt.shared.domain.valueobject.IdFaker
import cat.vonblum.chatogt.shared.domain.valueobject.StringFaker
import java.util.UUID

class UpdateUserNameCommandMother {

    companion object {

        fun create(
            id: UUID?,
            name: String?
        ): UpdateUserNameCommand = UpdateUserNameCommand(
            id ?: IdFaker.random(),
            name ?: StringFaker.name()
        )

    }

}
