package cat.vonblum.chatogt.shared.infrastructure.message

interface MessageConsumer {

    fun consume(message: Message)

}