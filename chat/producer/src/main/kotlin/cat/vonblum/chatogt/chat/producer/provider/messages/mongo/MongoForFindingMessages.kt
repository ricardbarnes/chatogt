package cat.vonblum.chatogt.chat.producer.provider.messages.mongo

import cat.vonblum.chatogt.chat.messages.ForFindingMessages
import cat.vonblum.chatogt.chat.messages.Message
import cat.vonblum.chatogt.chat.messages.MessageId
import cat.vonblum.chatogt.chat.shared.ChatId
import org.springframework.stereotype.Component

@Component
class MongoForFindingMessages : ForFindingMessages {

    override fun findById(messageId: MessageId): Message {
        TODO("Not yet implemented")
    }

    override fun findAllByChatId(chatId: ChatId): List<Message> {
        TODO("Not yet implemented")
    }

}