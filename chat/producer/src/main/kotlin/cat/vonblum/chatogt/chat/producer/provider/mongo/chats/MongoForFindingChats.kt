package cat.vonblum.chatogt.chat.producer.provider.mongo.chats

import cat.vonblum.chatogt.chat.chats.Chat
import cat.vonblum.chatogt.chat.chats.ForFindingChats
import cat.vonblum.chatogt.chat.producer.store.MongoReadStore
import cat.vonblum.chatogt.chat.shared.ChatId
import cat.vonblum.chatogt.chat.shared.UserId
import org.springframework.stereotype.Component

@Component
class MongoForFindingChats private constructor(
    private val store: MongoReadStore,
    private val repository: MongoChatRepository,
) : ForFindingChats {

    override fun findById(id: ChatId): Chat {
        return repository.findById(id)
    }

    override fun findAllIdsByUserId(userId: UserId): Set<ChatId> {
        return repository.findAllIdsByUserId(userId).toSet()
    }

}