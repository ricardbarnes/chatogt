package cat.vonblum.chatogt.usermanagement.infrastructure.handler.query

import kotlin.reflect.KClass

class QueryHandlerNotFoundException(message: String) : QueryHandlerException(message) {

    companion object {

        fun becauseOf(messageClass: KClass<out Any>): QueryHandlerNotFoundException =
            QueryHandlerNotFoundException("Query handler for class \"${messageClass.simpleName}\" not found.")

    }

}