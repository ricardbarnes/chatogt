package cat.vonblum.chatogt.usermanagement.shared.event

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.domain.valueobject.Id

interface EventStore {

    fun append(
        aggregateId: Id,
        expectedVersion: Int,
        events: Collection<Event>
    )

    fun load(aggregateId: Id): List<Event>

}