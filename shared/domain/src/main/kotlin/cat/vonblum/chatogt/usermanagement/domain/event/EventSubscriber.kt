package cat.vonblum.chatogt.usermanagement.domain.event

interface EventSubscriber {

    fun subscribedTo(): List<Any>

}