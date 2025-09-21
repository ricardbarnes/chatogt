package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.shared.infrastructure.handler.command.CommandDispatcher
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommandHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringCommandHandlerConfig {

    @Bean
    fun commandHandlers(): List<Any> {
        return listOf(
            CreateUserCommandHandler::class.java,
        )
    }

    @Bean
    fun commandDispatcher(handlers: List<Any>): CommandDispatcher {
        return CommandDispatcher(handlers)
    }

}