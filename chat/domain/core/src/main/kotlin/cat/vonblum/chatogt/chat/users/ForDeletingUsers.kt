package cat.vonblum.chatogt.chat.users

import cat.vonblum.chatogt.chat.shared.UserId

interface ForDeletingUsers {

    fun deleteById(id: UserId)

}