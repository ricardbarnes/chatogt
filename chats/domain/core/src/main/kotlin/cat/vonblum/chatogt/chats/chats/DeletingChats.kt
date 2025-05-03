package cat.vonblum.chatogt.chats.chats

import cat.vonblum.chatogt.chats.shared.ChatId

interface DeletingChats {

    fun deleteById(id: ChatId)

}