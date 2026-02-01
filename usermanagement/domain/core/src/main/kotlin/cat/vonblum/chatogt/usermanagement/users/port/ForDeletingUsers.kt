package cat.vonblum.chatogt.usermanagement.users.port

import cat.vonblum.chatogt.usermanagement.users.model.UserId

interface ForDeletingUsers {

    fun deleteById(id: UserId)

}