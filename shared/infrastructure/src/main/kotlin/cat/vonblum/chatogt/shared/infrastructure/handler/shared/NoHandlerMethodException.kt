package cat.vonblum.chatogt.shared.infrastructure.handler.shared

class NoHandlerMethodException(message: String) : HandlerException(message) {

    companion object {

        fun becauseOf(handler: Any): NoHandlerMethodException =
            NoHandlerMethodException("No handle method was found in class \"${handler::class.simpleName}\"")

    }

}