package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.shared.domain.valueobject.IdFaker
import java.util.*

object UserIdMother {

    fun create(id: UUID?): UserId = UserId(id ?: IdFaker.random())

    fun random(): UserId = UserId(IdFaker.random())

}
