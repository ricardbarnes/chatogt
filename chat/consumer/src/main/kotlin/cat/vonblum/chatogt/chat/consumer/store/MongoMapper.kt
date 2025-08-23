package cat.vonblum.chatogt.chat.consumer.store

import cat.vonblum.chatogt.chat.chats.ChatCreatedEvent
import cat.vonblum.chatogt.chat.messages.MessageCreatedEvent
import cat.vonblum.chatogt.chat.users.UserCreatedEvent
import cat.vonblum.chatogt.shared.domain.event.Event
import cat.vonblum.chats.shared.infrastructure.model.MongoChatCreatedEvent
import cat.vonblum.chats.shared.infrastructure.model.MongoEvent
import cat.vonblum.chats.shared.infrastructure.model.MongoMessageCreatedEvent
import cat.vonblum.chats.shared.infrastructure.model.MongoUserCreatedEvent
import org.springframework.stereotype.Component

@Component
class MongoMapper {

    fun map(event: Event): MongoEvent {
        return when (event) {
//            is UserCreatedEvent -> map(event)
//            is ChatCreatedEvent -> map(event)
//            is MessageCreatedEvent -> map(event)
            else -> {
                throw RuntimeException() // TODO
            }
        }
    }

    private fun map(event: UserCreatedEvent): MongoUserCreatedEvent {
        return MongoUserCreatedEvent(
            event.id.toString(),
            event.aggregateId.toString(),
            event.name,
            event.password,
            event.occurredOn
        )
    }

    private fun map(event: ChatCreatedEvent): MongoChatCreatedEvent {
        return MongoChatCreatedEvent(
            event.id.toString(),
            event.aggregateId.toString(),
            event.occurredOn,
            event.participantIds.map { it.toString() }
        )
    }

    private fun map(event: MessageCreatedEvent): MongoMessageCreatedEvent {
        return MongoMessageCreatedEvent(
            event.id.toString(),
            event.aggregateId.toString(),
            event.chatId.toString(),
            event.content,
            event.occurredOn
        )
    }

}