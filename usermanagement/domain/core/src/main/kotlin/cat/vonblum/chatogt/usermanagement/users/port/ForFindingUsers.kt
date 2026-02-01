package cat.vonblum.chatogt.usermanagement.users.port

import cat.vonblum.chatogt.usermanagement.users.aggregate.User
import cat.vonblum.chatogt.usermanagement.users.aggregate.UserEmail
import cat.vonblum.chatogt.usermanagement.users.aggregate.UserId

interface ForFindingUsers {

    fun findById(id: UserId): User

    fun findByEmail(name: UserEmail): User

}