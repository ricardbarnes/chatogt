package cat.vonblum.chatogt.usermanagement.domain.aggregate

import cat.vonblum.chatogt.usermanagement.domain.event.Event

abstract class AggregateRoot {

    private var events: MutableList<Event> = mutableListOf()

    protected abstract fun applyEvent(event: Event)

    /**
     * Applies historical events. Used for rehydration only.
     */
    protected fun applyEvents(events: List<Event>) {
        events.forEach { event -> applyEvent(event) }
    }

    protected fun record(event: Event) {
        events.add(event)
    }

    fun pullEvents(): List<Event> = events.also { events = mutableListOf() }

}