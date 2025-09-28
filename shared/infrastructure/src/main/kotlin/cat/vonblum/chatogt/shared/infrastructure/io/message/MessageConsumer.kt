package cat.vonblum.chatogt.shared.infrastructure.io.message

interface MessageConsumer {

    fun consume(message: Message)

}