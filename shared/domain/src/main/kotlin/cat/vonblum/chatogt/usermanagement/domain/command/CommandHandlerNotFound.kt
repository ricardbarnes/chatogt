package cat.vonblum.chatogt.usermanagement.domain.command

import cat.vonblum.chatogt.usermanagement.domain.error.Error
import kotlin.reflect.KClass

class CommandHandlerNotFound(message: String) : Error(message) {

    companion object {

        fun becauseOf(commandClass: KClass<out Any>): CommandHandlerNotFound =
            CommandHandlerNotFound("Command handler for class \"${commandClass.simpleName}\" not found.")

    }

}