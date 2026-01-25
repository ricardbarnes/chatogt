package cat.vonblum.chatogt.usermanagement.domain.aggregate

import cat.vonblum.chatogt.usermanagement.domain.event.Event

abstract class AggregateRoot {

    private var events = mutableListOf<Event>()

    protected var version = 0L

    protected abstract fun apply(event: Event)

    protected fun record(event: Event) =
        version++.also {
            apply(event)
            events.add(event)
        }

    fun pullEvents(): List<Event> =
        events.also {
            events = mutableListOf()
        }.toList()

    fun replay(events: List<Event>) =
        events.forEach { event ->
            run {
                apply(event)
                version = event.aggregateVersion + 1
            }
        }

}