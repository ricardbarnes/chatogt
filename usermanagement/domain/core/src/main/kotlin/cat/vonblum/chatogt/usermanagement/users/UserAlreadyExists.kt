package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.domain.error.Error

class UserAlreadyExists(override val message: String) : Error(message) {

    companion object {

        fun becauseOf(email: UserEmail): Error = UserAlreadyExists("User \"$email\" already exists")

    }

}