package cat.vonblum.chatogt.usermanagement.infrastructure.io.message

interface MessageResolver {

    fun resolve(message: Message)

}