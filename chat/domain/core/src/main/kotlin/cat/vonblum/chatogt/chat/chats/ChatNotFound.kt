package cat.vonblum.chatogt.chat.chats

import cat.vonblum.chatogt.chat.shared.ChatId
import cat.vonblum.chatogt.shared.domain.error.Error

class ChatNotFound(override val message: String) : Error(message) {

    companion object {

        fun becauseOf(chatId: ChatId): ChatNotFound = ChatNotFound("Chat ${chatId.value} not found.")

    }

}