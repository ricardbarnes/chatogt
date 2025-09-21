package cat.vonblum.chatogt.shared.infrastructure.handler.query

class NoQueryHandlerMethodException(message: String) : QueryHandlerException(message) {

    companion object {

        fun becauseOf(handler: Any): NoQueryHandlerMethodException =
            NoQueryHandlerMethodException("No query handler method was found in class \"${handler::class.simpleName}\"")

    }

}