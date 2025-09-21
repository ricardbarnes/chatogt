package cat.vonblum.chatogt.shared.infrastructure.handler.command

class NoCommandHandlerMethodException(message: String) : CommandHandlerException(message) {

    companion object {

        fun becauseOf(handler: Any): NoCommandHandlerMethodException =
            NoCommandHandlerMethodException("No command handler method was found in class \"${handler::class.simpleName}\"")

    }

}