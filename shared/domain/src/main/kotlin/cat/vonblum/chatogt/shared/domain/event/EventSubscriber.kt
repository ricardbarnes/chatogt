package cat.vonblum.chatogt.shared.domain.event

interface EventSubscriber {

    fun subscribedTo(): List<Any>

}