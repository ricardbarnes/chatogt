package cat.vonblum.chatogt.usermanagement.domain.command

import kotlin.reflect.KClass
import kotlin.reflect.full.declaredFunctions

class CommandHandlerDispatcher(
    private val handlers: Map<KClass<out Command>, CommandHandler>
) {

    fun dispatch(command: Command) {
        val handler = handlers[command::class]
            ?: throw CommandHandlerNotFound.becauseOf(command::class)

        val handleMethod = handler::class.declaredFunctions
            .firstOrNull { it.name == "handle" }
            ?: throw CommandHandlerMethodNotFound.becauseOf(command::class)

        handleMethod.call(handler, command)
    }

}
