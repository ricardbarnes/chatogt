package cat.vonblum.chatogt.chats.producer.adapter.chats

import cat.vonblum.chatogt.chats.chats.Chat
import cat.vonblum.chatogt.chats.chats.FindingChats
import cat.vonblum.chatogt.chats.producer.adapter.shared.MongoReadStore
import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.UserId
import org.springframework.stereotype.Component

@Component
class MongoFindingChats private constructor(
    private val store: MongoReadStore,
    private val repository: MongoChatRepository,
) : FindingChats {

    override fun findById(id: ChatId): Chat {
        return repository.findById(id)
    }

    override fun findAllIdsByUserId(userId: UserId): Set<ChatId> {
        return repository.findAllIdsByUserId(userId).toSet()
    }

}