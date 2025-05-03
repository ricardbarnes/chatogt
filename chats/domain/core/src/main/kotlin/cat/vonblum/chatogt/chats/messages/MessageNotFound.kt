package cat.vonblum.chatogt.chats.messages

import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.shared.domain.error.Error

class MessageNotFound(override val message: String) : Error(message) {

    companion object {

        fun becauseOf(chatId: ChatId): MessageNotFound = MessageNotFound("Message ${chatId.value} not found")

    }

}