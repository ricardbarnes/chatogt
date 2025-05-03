package cat.vonblum.chatogt.chats.chats

import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.shared.domain.error.Error

class ChatNotFound(override val message: String) : Error(message) {

    companion object {

        fun becauseOf(chatId: ChatId): ChatNotFound = ChatNotFound("Chat ${chatId.value} not found.")

    }

}