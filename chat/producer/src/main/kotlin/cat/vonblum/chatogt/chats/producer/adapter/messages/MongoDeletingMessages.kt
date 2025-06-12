package cat.vonblum.chatogt.chats.producer.adapter.messages

import cat.vonblum.chatogt.chats.messages.DeletingMessages
import cat.vonblum.chatogt.chats.messages.MessageId
import org.springframework.stereotype.Component

@Component
class MongoDeletingMessages : DeletingMessages {

    override fun deleteById(id: MessageId) {
        TODO("Not yet implemented")
    }

}