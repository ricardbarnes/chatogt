package cat.vonblum.chatogt.chat.chats

import cat.vonblum.chatogt.chat.shared.ChatId
import cat.vonblum.chatogt.chat.shared.UserId

interface FindingChats {

    fun findById(id: ChatId): Chat

    fun findAllIdsByUserId(userId: UserId): Set<ChatId>

}