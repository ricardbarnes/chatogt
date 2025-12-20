package cat.vonblum.chatogt.usermanagement.consumer.store.shared

import cat.vonblum.chatogt.usermanagement.domain.event.Event

data class EventStream(
    val version: Int,
    val events: List<Event>
) // Is this shared (for reads)?