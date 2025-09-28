package cat.vonblum.chatogt.shared.infrastructure.io.message

interface MessageResolver {

    fun resolve(message: Message)

}