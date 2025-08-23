package cat.vonblum.chatogt.chat.producer.provider.mongo.messages

import cat.vonblum.chatogt.chat.messages.FindingMessages
import cat.vonblum.chatogt.chat.messages.Message
import cat.vonblum.chatogt.chat.messages.MessageId
import cat.vonblum.chatogt.chat.shared.ChatId
import org.springframework.stereotype.Component

@Component
class MongoFindingMessages : FindingMessages {

    override fun findById(messageId: MessageId): Message {
        TODO("Not yet implemented")
    }

    override fun findAllByChatId(chatId: ChatId): List<Message> {
        TODO("Not yet implemented")
    }

}