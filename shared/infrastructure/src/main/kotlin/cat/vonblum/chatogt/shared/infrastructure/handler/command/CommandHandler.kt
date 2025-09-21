package cat.vonblum.chatogt.shared.infrastructure.handler.command

import cat.vonblum.chatogt.shared.domain.command.Command
import cat.vonblum.chatogt.shared.domain.command.CommandHandler
import java.lang.reflect.Method
import kotlin.reflect.KClass

/**
 * Generic handler class to register the required command handlers. It will perform the match from their corresponding
 * DTOs and automagically delegate the DTO handling to the corresponding handler.
 *
 * NOTE: In order for this to work, follow the conventional handler/DTO naming, "FooBarCommand" & "FooBarCommandHandler"
 * (e.g.: `CreateUserCommand` & `CreateUserCommandHandler`) for the registered handlers, as it works via reflection.
 */
class CommandDispatcher(private val handlers: List<Any>) {

    fun send(command: Command) {
        val handler = getHandlerClass(command::class)
        val dispatcherMethod = getDispatcherMethod(handler as CommandHandler)
        dispatcherMethod.invoke(command)
    }

    private fun getHandlerClass(messageClass: KClass<out Any>): Any {
        val handlerName = "${messageClass.simpleName}Handler"
        return handlers.find { it::class.simpleName == handlerName }
            ?: throw CommandHandlerNotFoundException.becauseOf(messageClass)
    }

    private fun getDispatcherMethod(commandHandler: CommandHandler): (Command) -> Unit {
        val method = getHandleMethod(commandHandler)
        return { command: Command ->
            method.invoke(commandHandler, command) ?: Unit
        }
    }

    private fun getHandleMethod(handler: Any): Method =
        handler::class.java.methods
            .find { it.name == "handle" && it.parameterCount == 1 }
            ?: throw NoCommandHandlerMethodException.becauseOf(handler)
}
