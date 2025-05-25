package cat.vonblum.chatogt.usermanagement.users.update

import cat.vonblum.chatogt.shared.domain.valueobject.IdFaker
import cat.vonblum.chatogt.shared.domain.valueobject.StringFaker
import java.util.UUID

class UpdateUserPasswordCommandMother {

    companion object {

        fun create(
            id: UUID?,
            password: String?
        ): UpdateUserPasswordCommand = UpdateUserPasswordCommand(
            id ?: IdFaker.random(),
            password ?: StringFaker.password()
        )

    }

}
