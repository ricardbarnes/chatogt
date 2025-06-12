package cat.vonblum.chatogt.chats.producer.adapter.shared.driver

import cat.vonblum.chatogt.shared.domain.event.Event
import cat.vonblum.chats.shared.infrastructure.model.MongoEvent
import org.springframework.stereotype.Component

@Component
class MongoEventMapper {

    fun map(types: List<MongoEvent>): List<Event> {
        return types.map { map(it) }
    }

    private fun map(mongoEvent: MongoEvent): Event {
        return when (mongoEvent) { // TODO...
//            is MongoChatCreatedEvent -> aChatCreatedEvent(mongoEvent)
            else -> throw IllegalArgumentException("unknown event type: $mongoEvent")
        }
    }

}