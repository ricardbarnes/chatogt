package cat.vonblum.chatogt.shared.domain.handler

class UnrecognizedHandlerException(message: String) : HandlerException(message) {

    companion object {

        fun becauseOf(handler: Any): UnrecognizedHandlerException =
            UnrecognizedHandlerException("Unrecognized handler type ${handler::class.qualifiedName}")

    }

}