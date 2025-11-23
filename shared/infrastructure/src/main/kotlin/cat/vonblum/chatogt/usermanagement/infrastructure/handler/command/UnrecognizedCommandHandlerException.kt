package cat.vonblum.chatogt.usermanagement.infrastructure.handler.command

class UnrecognizedCommandHandlerException(message: String) : CommandHandlerException(message) {

    companion object {

        fun becauseOf(handler: Any): UnrecognizedCommandHandlerException =
            UnrecognizedCommandHandlerException("Unrecognized command handler type ${handler::class.qualifiedName}")

    }

}