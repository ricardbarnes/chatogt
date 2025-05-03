package cat.vonblum.chatogt.chats.producer.adapter.chats

import cat.vonblum.chatogt.chats.chats.DeletingChats
import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.shared.infrastructure.annotation.DrivenAdapter
import org.springframework.stereotype.Component

@DrivenAdapter
@Component
class MongoDeletingChats : DeletingChats {

    override fun deleteById(id: ChatId) {
        TODO("Not yet implemented")
    }

}