package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.domain.valueobject.Id
import cat.vonblum.chatogt.usermanagement.shared.event.EventStore
import cat.vonblum.chatogt.usermanagement.shared.event.shared.ProtoEventMapper

class MongoEventStore(
    private val protoMapper: ProtoEventMapper,
) : EventStore {

    override fun append(event: Event) {
        TODO("Not yet implemented")
    }

    override fun load(aggregateId: Id): List<Event> {
        TODO("Not yet implemented")
    }

}