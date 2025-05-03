package cat.vonblum.chatogt.chats.users

import cat.vonblum.chatogt.chats.shared.UserId

interface DeletingUsers {

    fun deleteById(id: UserId)

}