package cat.vonblum.chatogt.usermanagement.infrastructure.handler.query

import cat.vonblum.chatogt.usermanagement.domain.query.Query
import cat.vonblum.chatogt.usermanagement.domain.query.QueryHandler
import cat.vonblum.chatogt.usermanagement.domain.query.Response
import java.lang.reflect.Method
import kotlin.reflect.KClass

/**
 * Generic query dispatcher that explicitly maps Query types to their handlers.
 */
class QueryDispatcher(
    private val handlerMap: Map<KClass<out Query>, QueryHandler>
) {

    fun send(query: Query): Response? {
        val handler = handlerMap[query::class]
            ?: throw QueryHandlerNotFoundException.becauseOf(query::class)

        val method = getHandleMethod(handler)
        return method.invoke(handler, query) as? Response
    }

    private fun getHandleMethod(handler: QueryHandler): Method =
        handler::class.java.methods
            .find { it.name == "handle" && it.parameterCount == 1 }
            ?: throw NoQueryHandlerMethodException.becauseOf(handler)
}
