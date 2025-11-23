package cat.vonblum.chatogt.chat.messages

import cat.vonblum.chatogt.chat.shared.ChatId
import cat.vonblum.chatogt.usermanagement.domain.error.Error

class MessageNotFound(override val message: String) : Error(message) {

    companion object {

        fun becauseOf(chatId: ChatId): MessageNotFound = MessageNotFound("Message ${chatId.value} not found")

    }

}