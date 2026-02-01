package cat.vonblum.chatogt.usermanagement.users.error

import cat.vonblum.chatogt.usermanagement.domain.error.Error
import cat.vonblum.chatogt.usermanagement.users.model.UserEmail
import cat.vonblum.chatogt.usermanagement.users.model.UserId

class UserNotFoundError(override val message: String) : Error(message) {

    companion object {

        fun becauseOf(id: UserId): Error = UserNotFoundError("User ID \"$id\" not found")

        fun becauseOf(email: UserEmail): Error = UserNotFoundError("User email \"$email\" not found")

    }

}