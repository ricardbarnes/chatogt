package cat.vonblum.chatogt.chat.producer.provider.mongo.chats

import cat.vonblum.chatogt.chat.chats.DeletingChats
import cat.vonblum.chatogt.chat.shared.ChatId
import org.springframework.stereotype.Component

@Component
class MongoDeletingChats : DeletingChats {

    override fun deleteById(id: ChatId) {
        TODO("Not yet implemented")
    }

}