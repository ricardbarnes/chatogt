package cat.vonblum.chatogt.usermanagement.domain.command

import kotlin.reflect.KClass
import kotlin.reflect.full.declaredFunctions

class CommandHandlerDispatcher(
    private val handlers: Map<KClass<out Command>, CommandHandler>
) {

    companion object {

        const val HANDLER_METHOD_NAME = "handle"

    }

    fun dispatch(command: Command) {
        val handler = handlers[command::class]
            ?: throw CommandHandlerNotFound.becauseOf(command::class)

        val handleMethod = handler::class.declaredFunctions
            .firstOrNull { it.name == HANDLER_METHOD_NAME }
            ?: throw CommandHandlerMethodNotFound.becauseOf(command::class)

        handleMethod.call(handler, command)
    }

}
