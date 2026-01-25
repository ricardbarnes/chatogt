package cat.vonblum.chatogt.usermanagement.infrastructure.event

import cat.vonblum.chatogt.usermanagement.domain.event.Event

data class EventStream(
    val version: Int,
    val events: List<Event>
)