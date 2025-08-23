package cat.vonblum.chatogt.chat.producer.provider.mongo.messages

import cat.vonblum.chatogt.chat.messages.DeletingMessages
import cat.vonblum.chatogt.chat.messages.MessageId
import org.springframework.stereotype.Component

@Component
class MongoDeletingMessages : DeletingMessages {

    override fun deleteById(id: MessageId) {
        TODO("Not yet implemented")
    }

}