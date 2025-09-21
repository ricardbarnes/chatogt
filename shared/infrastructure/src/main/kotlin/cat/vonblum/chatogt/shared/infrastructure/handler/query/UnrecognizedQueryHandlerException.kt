package cat.vonblum.chatogt.shared.infrastructure.handler.query

class UnrecognizedQueryHandlerException(message: String) : QueryHandlerException(message) {

    companion object {

        fun becauseOf(handler: Any): UnrecognizedQueryHandlerException =
            UnrecognizedQueryHandlerException("Unrecognized query handler type ${handler::class.qualifiedName}")

    }

}