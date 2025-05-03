package cat.vonblum.chatogt.chats.producer.adapter.messages

import cat.vonblum.chatogt.chats.messages.FindingMessages
import cat.vonblum.chatogt.chats.messages.Message
import cat.vonblum.chatogt.chats.messages.MessageId
import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.shared.infrastructure.annotation.DrivenAdapter
import org.springframework.stereotype.Component

@DrivenAdapter
@Component
class MongoFindingMessages : FindingMessages {

    override fun findById(messageId: MessageId): Message {
        TODO("Not yet implemented")
    }

    override fun findAllByChatId(chatId: ChatId): List<Message> {
        TODO("Not yet implemented")
    }

}