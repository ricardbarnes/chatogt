package cat.vonblum.chatogt.shared.infrastructure.handler.query

import cat.vonblum.chatogt.shared.domain.query.Query
import cat.vonblum.chatogt.shared.domain.query.QueryHandler
import cat.vonblum.chatogt.shared.domain.query.Response
import java.lang.reflect.Method
import kotlin.reflect.KClass

/**
 * Generic handler class to register the required query handlers. It will perform the match from their corresponding
 * DTOs and automagically delegate the DTO handling to the corresponding handler.
 *
 * NOTE: In order for this to work, follow the conventional handler/DTO naming, "FooBarQuery" & "FooBarQueryHandler"
 * (e.g.: `FindUserQuery` & `FindUserQueryHandler`) for the registered handlers, as it works via reflection.
 */
class QueryDispatcher(private val handlers: List<Any>) {

    fun send(query: Query): Response? {
        val handler = getHandlerClass(query::class)
        val askerMethod = getAskerMethod(handler as QueryHandler)
        return askerMethod.invoke(query)
    }

    private fun getHandlerClass(messageClass: KClass<out Any>): Any {
        val handlerName = "${messageClass.simpleName}Handler"
        return handlers.find { it::class.simpleName == handlerName }
            ?: throw QueryHandlerNotFoundException.becauseOf(messageClass)
    }

    private fun getAskerMethod(queryHandler: QueryHandler): (Query) -> Response? {
        val method = getHandleMethod(queryHandler)
        return { query: Query -> method.invoke(queryHandler, query) as Response? }
    }

    private fun getHandleMethod(handler: Any): Method =
        handler::class.java.methods
            .find { it.name == "handle" && it.parameterCount == 1 }
            ?: throw NoQueryHandlerMethodException.becauseOf(handler)
}
