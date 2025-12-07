package cat.vonblum.chatogt.usermanagement.domain.command

import cat.vonblum.chatogt.usermanagement.domain.error.Error

class CommandHandlerMethodNotFound(message: String) : Error(message) {

    companion object {

        fun becauseOf(handler: Any): CommandHandlerMethodNotFound =
            CommandHandlerMethodNotFound("No command handler method was found in class \"${handler::class.simpleName}\"")

    }

}