package cat.vonblum.chatogt.usermanagement.users.error

import cat.vonblum.chatogt.usermanagement.domain.error.Error
import cat.vonblum.chatogt.usermanagement.users.aggregate.UserEmail

class UserAlreadyExistsError(override val message: String) : Error(message) {

    companion object {

        fun becauseOf(email: UserEmail): Error = UserAlreadyExistsError("User \"$email\" already exists")

    }

}