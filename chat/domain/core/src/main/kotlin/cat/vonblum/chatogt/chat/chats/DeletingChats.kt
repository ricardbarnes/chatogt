package cat.vonblum.chatogt.chat.chats

import cat.vonblum.chatogt.chat.shared.ChatId

interface DeletingChats {

    fun deleteById(id: ChatId)

}