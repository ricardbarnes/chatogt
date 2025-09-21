package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.shared.infrastructure.handler.command.CommandDispatcher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringCommandHandlerConfig {

    @Bean
    fun commandHandlers(): List<Any> {
        return emptyList()
    }

    @Bean
    fun commandDispatcher(handlers: List<Any>): CommandDispatcher {
        return CommandDispatcher(handlers)
    }

}