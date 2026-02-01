package cat.vonblum.chatogt.usermanagement.users.port

import cat.vonblum.chatogt.usermanagement.users.aggregate.User

interface ForStoringUsers {

    fun store(user: User)

}