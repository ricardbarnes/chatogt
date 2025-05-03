package cat.vonblum.chatogt.users.users

import cat.vonblum.chatogt.shared.domain.error.Error

class UserNotFound(override val message: String) : Error(message) {

    companion object {

        fun becauseOf(id: UserId): Error = UserNotFound("User ID \"$id\" not found")

    }

}