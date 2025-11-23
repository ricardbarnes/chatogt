package cat.vonblum.chatogt.usermanagement.infrastructure.handler.command

import cat.vonblum.chatogt.usermanagement.domain.command.Command
import cat.vonblum.chatogt.usermanagement.domain.command.CommandHandler
import java.lang.reflect.Method
import kotlin.reflect.KClass

/**
 * Generic command dispatcher that explicitly maps Command types to their handlers.
 */
class CommandDispatcher(
    private val handlerMap: Map<KClass<out Command>, CommandHandler>
) {

    fun send(command: Command) {
        val handler = handlerMap[command::class]
            ?: throw CommandHandlerNotFoundException.becauseOf(command::class)

        val method = getHandleMethod(handler)
        method.invoke(handler, command)
    }

    private fun getHandleMethod(handler: CommandHandler): Method =
        handler::class.java.methods
            .find { it.name == "handle" && it.parameterCount == 1 }
            ?: throw NoCommandHandlerMethodException.becauseOf(handler)
}
