package cat.vonblum.chatogt.chats.consumer.mapper

import cat.vonblum.chatogt.chats.chats.ChatCreatedEvent
import cat.vonblum.chatogt.chats.messages.MessageCreatedEvent
import cat.vonblum.chatogt.shared.domain.event.Event
import cat.vonblum.chatogt.chats.infrastructure.model.MongoChatCreatedEvent
import cat.vonblum.chatogt.chats.infrastructure.model.MongoEvent
import cat.vonblum.chatogt.chats.infrastructure.model.MongoMessageCreatedEvent
import cat.vonblum.chatogt.chats.infrastructure.model.MongoUserCreatedEvent
import cat.vonblum.chatogt.chats.users.UserCreatedEvent
import org.springframework.stereotype.Component

@Component
class MongoMapper {

    fun map(event: Event): MongoEvent {
        return when (event) {
            is UserCreatedEvent -> map(event)
            is ChatCreatedEvent -> map(event)
            is MessageCreatedEvent -> map(event)
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