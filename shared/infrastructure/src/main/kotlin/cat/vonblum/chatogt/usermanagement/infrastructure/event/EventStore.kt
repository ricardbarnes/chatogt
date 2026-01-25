package cat.vonblum.chatogt.usermanagement.infrastructure.event

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.domain.valueobject.Id

interface EventStore {

    fun append(event: Event)

    fun load(aggregateId: Id): List<Event>

}