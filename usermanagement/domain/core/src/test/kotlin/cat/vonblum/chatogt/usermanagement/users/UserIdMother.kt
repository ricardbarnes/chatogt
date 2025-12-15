package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.domain.valueobject.IdFaker
import java.util.*

object UserIdMother {

    fun create(id: UUID?): UserId = UserId(id ?: IdFaker.random())

}
