package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.usermanagement.domain.command.Command
import cat.vonblum.chatogt.usermanagement.domain.command.CommandHandler
import cat.vonblum.chatogt.usermanagement.infrastructure.handler.command.CommandDispatcher
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommandHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.reflect.KClass

@Configuration
class SpringCommandHandlerConfig {

    @Bean
    fun commandHandlingMap(
        createUserCommandHandler: CreateUserCommandHandler,
        // add further command handlers upon here
    ): Map<KClass<out Command>, CommandHandler> {
        return mapOf(
            CreateUserCommand::class as KClass<out Command> to createUserCommandHandler as CommandHandler,
            // add further command to handler mappings upon here
        )
    }

    @Bean
    fun commandDispatcher(commandHandlingMap: Map<KClass<out Command>, CommandHandler>): CommandDispatcher {
        return CommandDispatcher(commandHandlingMap)
    }

}

