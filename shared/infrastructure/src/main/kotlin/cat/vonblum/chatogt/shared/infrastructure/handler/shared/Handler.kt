package cat.vonblum.chatogt.shared.infrastructure.handler.shared

import cat.vonblum.chatogt.shared.domain.command.Command
import cat.vonblum.chatogt.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.shared.domain.query.Query
import cat.vonblum.chatogt.shared.domain.query.QueryHandler
import cat.vonblum.chatogt.shared.domain.query.Response
import java.lang.reflect.Method
import kotlin.reflect.KClass

/**
 * Generic handler class to register the required handlers. It will perform the match from their corresponding
 * DTOs and automagically delegate the DTO handling to the corresponding handler.
 *
 * NOTE: In order for this to work, follow the conventional handler/DTO naming, "FooBarDto" & "FooBarDtoHandler"
 * (e.g.: `FooBarQuery` & `FooBarQueryHandler`) for the registered handlers, as it works via reflection.
 */
class Handler(private val handlers: List<Any>) {

    fun send(message: Any): Response? {
        return when (val handler = getHandlerClass(message::class)) {
            is QueryHandler -> {
                val askerMethod = getAskerMethod(handler)
                askerMethod.invoke(message as Query)
            }

            is CommandHandler -> {
                val dispatcherMethod = getDispatcherMethod(handler)
                dispatcherMethod.invoke(message as Command)
                null
            }

            else -> throw UnrecognizedHandlerException.becauseOf(handler)
        }
    }

    private fun getHandlerClass(messageClass: KClass<out Any>): Any {
        val handlerName = "${messageClass.simpleName}Handler"
        return handlers.find { it::class.simpleName == handlerName }
            ?: throw HandlerNotFoundException.becauseOf(messageClass)
    }

    private fun getDispatcherMethod(handler: CommandHandler): (Command) -> Unit {
        val method = getHandleMethod(handler)
        return { command: Command ->
            method.invoke(handler, command) ?: Unit
        }
    }

    private fun getAskerMethod(handler: QueryHandler): (Query) -> Response? {
        val method = getHandleMethod(handler)
        return { command: Query -> method.invoke(handler, command) as Response? }
    }

    private fun getHandleMethod(handler: Any): Method =
        handler::class.java.methods
            .find { it.name == "handle" && it.parameterCount == 1 }
            ?: throw NoHandlerMethodException.becauseOf(handler)

}