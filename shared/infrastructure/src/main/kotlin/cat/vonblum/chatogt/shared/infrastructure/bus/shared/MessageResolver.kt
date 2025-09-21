package cat.vonblum.chatogt.shared.infrastructure.bus.shared

interface MessageResolver {

    fun resolve(message: Message)

}