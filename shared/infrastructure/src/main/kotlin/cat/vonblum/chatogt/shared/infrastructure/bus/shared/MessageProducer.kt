package cat.vonblum.chatogt.shared.infrastructure.bus.shared

interface MessageProducer {

    fun send(envelope: Message)

}