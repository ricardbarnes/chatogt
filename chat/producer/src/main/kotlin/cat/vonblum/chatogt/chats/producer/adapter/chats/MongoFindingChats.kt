package cat.vonblum.chatogt.chats.producer.adapter.chats

import cat.vonblum.chatogt.chats.chats.Chat
import cat.vonblum.chatogt.chats.chats.FindingChats
import cat.vonblum.chatogt.chats.producer.repository.ChatRepository
import cat.vonblum.chatogt.chats.producer.store.ReadStore
import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.shared.infrastructure.annotation.DrivenAdapter
import org.springframework.stereotype.Component

@DrivenAdapter
@Component
class MongoFindingChats(
    private val store: ReadStore,
    private val repository: ChatRepository,
) : FindingChats {

    override fun findById(id: ChatId): Chat {
        return repository.findById(id)
    }

    override fun findAllIdsByUserId(userId: UserId): Set<ChatId> {
        return repository.findAllIdsByUserId(userId).toSet()
    }

}