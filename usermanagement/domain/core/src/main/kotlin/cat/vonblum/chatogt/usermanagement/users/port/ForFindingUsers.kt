package cat.vonblum.chatogt.usermanagement.users.port

import cat.vonblum.chatogt.usermanagement.users.model.User
import cat.vonblum.chatogt.usermanagement.users.model.UserEmail
import cat.vonblum.chatogt.usermanagement.users.model.UserId

interface ForFindingUsers {

    fun findById(id: UserId): User

    fun findByEmail(name: UserEmail): User

}