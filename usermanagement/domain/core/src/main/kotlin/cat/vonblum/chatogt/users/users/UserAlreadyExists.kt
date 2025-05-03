package cat.vonblum.chatogt.users.users

import cat.vonblum.chatogt.shared.domain.error.Error

class UserAlreadyExists(override val message: String) : Error(message) {

    companion object {

        fun becauseOf(name: UserName): Error = UserAlreadyExists("User \"$name\" already exists")

    }

}