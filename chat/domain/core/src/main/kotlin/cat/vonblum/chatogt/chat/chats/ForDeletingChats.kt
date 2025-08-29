package cat.vonblum.chatogt.chat.chats

import cat.vonblum.chatogt.chat.shared.ChatId

interface ForDeletingChats {

    fun deleteById(id: ChatId)

}