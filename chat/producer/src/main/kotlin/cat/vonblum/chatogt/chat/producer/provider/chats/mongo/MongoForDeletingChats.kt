package cat.vonblum.chatogt.chat.producer.provider.chats.mongo

import cat.vonblum.chatogt.chat.chats.ForDeletingChats
import cat.vonblum.chatogt.chat.shared.ChatId
import org.springframework.stereotype.Component

@Component
class MongoForDeletingChats : ForDeletingChats {

    override fun deleteById(id: ChatId) {
        TODO("Not yet implemented")
    }

}