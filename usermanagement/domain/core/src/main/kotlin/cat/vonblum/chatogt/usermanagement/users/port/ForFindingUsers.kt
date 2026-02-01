package cat.vonblum.chatogt.usermanagement.users.port

import cat.vonblum.chatogt.usermanagement.users.model.UserEmail
import cat.vonblum.chatogt.usermanagement.users.model.UserId
import cat.vonblum.chatogt.usermanagement.users.view.UserView

interface ForFindingUsers {

    fun findById(id: UserId): UserView

    fun findByEmail(name: UserEmail): UserView

}