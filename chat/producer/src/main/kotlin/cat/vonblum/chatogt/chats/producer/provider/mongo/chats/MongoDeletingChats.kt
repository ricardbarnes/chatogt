package cat.vonblum.chatogt.chats.producer.provider.mongo.chats

import cat.vonblum.chatogt.chats.chats.DeletingChats
import cat.vonblum.chatogt.chats.shared.ChatId
import org.springframework.stereotype.Component

@Component
class MongoDeletingChats : DeletingChats {

    override fun deleteById(id: ChatId) {
        TODO("Not yet implemented")
    }

}