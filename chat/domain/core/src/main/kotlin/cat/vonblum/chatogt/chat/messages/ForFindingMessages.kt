package cat.vonblum.chatogt.chat.messages

import cat.vonblum.chatogt.chat.shared.ChatId

interface ForFindingMessages {

    fun findById(messageId: MessageId): Message

    fun findAllByChatId(chatId: ChatId): List<Message>

}