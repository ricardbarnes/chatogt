package cat.vonblum.chatogt.shared.infrastructure.message

interface MessageProducer {

    fun send(envelope: Message)

}