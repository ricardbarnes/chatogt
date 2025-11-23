package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.usermanagement.domain.query.Query
import cat.vonblum.chatogt.usermanagement.domain.query.QueryHandler
import cat.vonblum.chatogt.usermanagement.infrastructure.handler.query.QueryDispatcher
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByIdQuery
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByIdQueryHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.reflect.KClass

@Configuration
class SpringQueryHandlerConfig {

    @Bean
    fun queryHandlingMap(
        findUserByIdQueryHandler: FindUserByIdQueryHandler,
        // add further command handlers upon here
    ): Map<KClass<out Query>, QueryHandler> {
        return mapOf(
            FindUserByIdQuery::class as KClass<out Query> to findUserByIdQueryHandler as QueryHandler,
            // add further command to handler mappings upon here
        )
    }

    @Bean
    fun queryDispatcher(queryHandlingMap: Map<KClass<out Query>, QueryHandler>): QueryDispatcher {
        return QueryDispatcher(queryHandlingMap)
    }

}

