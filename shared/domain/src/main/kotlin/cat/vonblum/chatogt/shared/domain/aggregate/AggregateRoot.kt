package cat.vonblum.chatogt.shared.domain.aggregate

import cat.vonblum.chatogt.shared.domain.event.Event

abstract class AggregateRoot {

    private var events: MutableList<Event> = mutableListOf()

    protected abstract fun applyEvent(event: Event)

    /**
     * Applies historical events. Used for rehydration only, via reflection.
     */
    protected fun applyEvents(events: List<Event>) {
        events.forEach { event -> applyEvent(event) }
    }

    protected fun record(event: Event) {
        events.add(event)
    }

    fun pullEvents(): List<Event> = events.also { events = mutableListOf() }

}