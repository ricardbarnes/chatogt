package cat.vonblum.chatogt.usermanagement.infrastructure.io.message

interface MessageProducer {

    fun send(message: Message)

}