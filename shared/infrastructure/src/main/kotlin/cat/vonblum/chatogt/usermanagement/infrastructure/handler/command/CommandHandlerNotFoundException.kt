package cat.vonblum.chatogt.usermanagement.infrastructure.handler.command

import kotlin.reflect.KClass

class CommandHandlerNotFoundException(message: String) : CommandHandlerException(message) {

    companion object {

        fun becauseOf(messageClass: KClass<out Any>): CommandHandlerNotFoundException =
            CommandHandlerNotFoundException("Command handler for class \"${messageClass.simpleName}\" not found.")

    }

}