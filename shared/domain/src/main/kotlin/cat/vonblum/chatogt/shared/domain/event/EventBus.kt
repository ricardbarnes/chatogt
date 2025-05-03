package cat.vonblum.chatogt.shared.domain.event

interface EventBus {

    fun publish(events: List<Event>)

}