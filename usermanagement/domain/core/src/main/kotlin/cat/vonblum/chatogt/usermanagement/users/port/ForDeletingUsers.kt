package cat.vonblum.chatogt.usermanagement.users.port

import cat.vonblum.chatogt.usermanagement.users.aggregate.UserId

interface ForDeletingUsers {

    fun deleteById(id: UserId)

}