package cat.vonblum.chatogt.usermanagement.users.port

import cat.vonblum.chatogt.usermanagement.users.model.User

interface ForStoringUsers {

    fun store(user: User)

}