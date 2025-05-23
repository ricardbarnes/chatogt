package cat.vonblum.chatogt.usermanagement.users

import java.util.*

class UserIdMother {

    companion object {

        fun create(id: UUID?): UserId = UserId(id ?: UUID.randomUUID())

    }

}
