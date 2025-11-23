package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.domain.error.Error

class UserNotFound(override val message: String) : Error(message) {

    companion object {

        fun becauseOf(id: UserId): Error = UserNotFound("User ID \"$id\" not found")

        fun becauseOf(id: UserName): Error = UserNotFound("User name \"$id\" not found")

    }

}