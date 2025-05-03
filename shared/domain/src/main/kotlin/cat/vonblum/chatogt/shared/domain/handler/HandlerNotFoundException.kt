package cat.vonblum.chatogt.shared.domain.handler

import kotlin.reflect.KClass

class HandlerNotFoundException(message: String) : HandlerException(message) {

    companion object {

        fun becauseOf(messageClass: KClass<out Any>): HandlerNotFoundException =
            HandlerNotFoundException("Handler for class \"${messageClass.simpleName}\" not found.")

    }

}