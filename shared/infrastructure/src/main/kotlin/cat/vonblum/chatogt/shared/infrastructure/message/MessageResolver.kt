package cat.vonblum.chatogt.shared.infrastructure.message

interface MessageResolver {

    fun resolve(message: Message)

}