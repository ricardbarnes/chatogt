package cat.vonblum.chatogt.usermanagement.shared.event

import cat.vonblum.chatogt.usermanagement.domain.event.Event

class EventStream(
    val version: Int,
    val events: List<Event>
)