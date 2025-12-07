package cat.vonblum.chatogt.usermanagement.domain.command

import kotlin.reflect.KClass
import kotlin.reflect.full.declaredFunctions

class CommandHandlerMap(
    private val handlers: Map<KClass<out Command>, CommandHandler>
) : Map<KClass<out Command>, CommandHandler> by handlers {

    fun handle(command: Command) {
        val handler = handlers[command::class]
            ?: throw CommandHandlerNotFound.becauseOf(command::class)

        val handleMethod = handler::class.declaredFunctions
            .firstOrNull { it.name == "handle" }
            ?: throw CommandHandlerMethodNotFound.becauseOf(command::class)

        handleMethod.call(handler, command)
    }

}
