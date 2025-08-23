package cat.vonblum.chatogt.chat.users

import cat.vonblum.chatogt.chat.shared.UserId

interface DeletingUsers {

    fun deleteById(id: UserId)

}