package cat.vonblum.chatogt.chat.chats

import cat.vonblum.chatogt.chat.shared.ChatId
import cat.vonblum.chatogt.chat.shared.UserId

interface ForFindingChats {

    fun findById(id: ChatId): Chat

    fun findAllIdsByUserId(userId: UserId): Set<ChatId>

}