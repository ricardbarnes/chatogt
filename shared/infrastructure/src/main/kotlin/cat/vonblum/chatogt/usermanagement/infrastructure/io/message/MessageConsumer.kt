package cat.vonblum.chatogt.usermanagement.infrastructure.io.message

interface MessageConsumer {

    fun consume(message: Message)

}