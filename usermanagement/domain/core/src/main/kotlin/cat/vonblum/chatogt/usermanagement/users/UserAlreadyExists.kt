package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.domain.error.Error

class UserAlreadyExists(override val message: String) : Error(message) {

    companion object {

        fun becauseOf(name: UserName): Error = UserAlreadyExists("User \"$name\" already exists")

    }

}