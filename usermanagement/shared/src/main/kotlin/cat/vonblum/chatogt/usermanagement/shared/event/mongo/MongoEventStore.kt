package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.domain.valueobject.Id
import cat.vonblum.chatogt.usermanagement.shared.event.EventStore
import cat.vonblum.chatogt.usermanagement.shared.event.shared.ProtoEventMapper
import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent

class MongoEventStore(
    private val protoMapper: ProtoEventMapper,
) : EventStore {

    override fun append(event: Event) {
        when (event) {
            is UserCreatedEvent -> append(event)
            else -> throw IllegalArgumentException("event type is not handled: $event")
        }
    }

    override fun load(aggregateId: Id): List<Event> {
        TODO()
    }

    private fun append(event: UserCreatedEvent) {
        val proto = protoMapper.toInfra(event)
        val serialized = proto.toByteArray()
        TODO()
    }

}