package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.domain.valueobject.Id
import cat.vonblum.chatogt.usermanagement.shared.event.EventStore
import cat.vonblum.chatogt.usermanagement.shared.event.shared.ProtoEventMapper
import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent

class MongoEventStore(
    private val repository: MongoEventRepository,
    private val protoMapper: ProtoEventMapper,
) : EventStore {

    override fun append(
        aggregateId: Id,
        expectedVersion: Int,
        events: Collection<Event>
    ) {
        TODO()
    }

    override fun load(aggregateId: Id): List<Event> {
        TODO()
    }

}