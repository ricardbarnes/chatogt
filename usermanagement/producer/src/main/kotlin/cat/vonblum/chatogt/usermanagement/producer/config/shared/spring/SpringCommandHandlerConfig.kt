package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.shared.domain.command.Command
import cat.vonblum.chatogt.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.shared.infrastructure.handler.command.CommandDispatcher
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
    ): Map<KClass<out Command>, CommandHandler> {
        return mapOf(
            CreateUserCommand::class as KClass<out Command> to createUserCommandHandler as CommandHandler,
        )
    }

    @Bean
    fun commandDispatcher(commandHandlingMap: Map<KClass<out Command>, CommandHandler>): CommandDispatcher {
        return CommandDispatcher(commandHandlingMap)
    }

}

