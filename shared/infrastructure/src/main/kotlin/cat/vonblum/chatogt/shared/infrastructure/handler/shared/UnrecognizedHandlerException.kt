package cat.vonblum.chatogt.shared.infrastructure.handler.shared

class UnrecognizedHandlerException(message: String) : HandlerException(message) {

    companion object {

        fun becauseOf(handler: Any): UnrecognizedHandlerException =
            UnrecognizedHandlerException("Unrecognized handler type ${handler::class.qualifiedName}")

    }

}