package cat.vonblum.chatogt.usermanagement.users

import java.util.*

object UserIdMother {

    fun create(id: UUID?): UserId = UserId(id ?: UUID.randomUUID())

    fun random(): UserId = UserId(UUID.randomUUID())

}
