package cat.vonblum.chatogt.usermanagement.users.port

import cat.vonblum.chatogt.usermanagement.users.model.User

interface ForSavingUsers {

    fun save(user: User)

}