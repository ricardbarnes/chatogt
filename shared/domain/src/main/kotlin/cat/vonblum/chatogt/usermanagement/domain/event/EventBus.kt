package cat.vonblum.chatogt.usermanagement.domain.event

interface EventBus {

    fun publish(events: List<Event>)

}