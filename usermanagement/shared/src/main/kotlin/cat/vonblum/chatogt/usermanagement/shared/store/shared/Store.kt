package cat.vonblum.chatogt.usermanagement.shared.store.shared

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.domain.valueobject.Id

interface Store {

    fun append(event: Event)

    fun load(aggregateId: Id): List<Event>

}