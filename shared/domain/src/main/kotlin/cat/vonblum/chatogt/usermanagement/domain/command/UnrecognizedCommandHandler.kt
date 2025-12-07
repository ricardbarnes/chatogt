package cat.vonblum.chatogt.usermanagement.domain.command

import cat.vonblum.chatogt.usermanagement.domain.error.Error

class UnrecognizedCommandHandler(message: String) : Error(message) {

    companion object {

        fun becauseOf(handler: Any): UnrecognizedCommandHandler =
            UnrecognizedCommandHandler("Unrecognized command handler type ${handler::class.qualifiedName}")

    }

}