package cat.vonblum.chatogt.shared.infrastructure.io.message

interface MessageProducer {

    fun send(message: Message)

}