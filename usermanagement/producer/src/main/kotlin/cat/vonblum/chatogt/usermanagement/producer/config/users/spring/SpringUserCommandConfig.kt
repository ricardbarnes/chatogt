package cat.vonblum.chatogt.usermanagement.producer.config.users.spring

import cat.vonblum.chatogt.usermanagement.domain.command.Command
import cat.vonblum.chatogt.usermanagement.domain.command.CommandHandler
import cat.vonblum.chatogt.usermanagement.domain.command.CommandHandlerDispatcher
import cat.vonblum.chatogt.usermanagement.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.domain.generator.IdGenerator
import cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka.KafkaUserCommandHandler
import cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka.KafkaUserCommandMapper
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommandHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.reflect.KClass

@Configuration
class SpringUserCommandConfig {

    @Bean
    fun createUserCommandHandler(
        idGenerator: IdGenerator,
        eventBus: EventBus
    ): CreateUserCommandHandler {
        return CreateUserCommandHandler(
            idGenerator,
            eventBus
        )
    }

    @Bean
    fun userCommandHandlerMap(
        createUserCommandHandler: CreateUserCommandHandler
    ): Map<KClass<out Command>, CommandHandler> {
        return mapOf(
            CreateUserCommand::class as KClass<out Command> to createUserCommandHandler as CommandHandler,
        )
    }

    @Bean
    fun userCommandHandlerDispatcher(
        userCommandHandlerMap: Map<KClass<out Command>, CommandHandler>
    ): CommandHandlerDispatcher {
        return CommandHandlerDispatcher(userCommandHandlerMap)
    }

    @Bean
    fun kafkaUserCommandMapper(): KafkaUserCommandMapper {
        return KafkaUserCommandMapper()
    }

    @Bean
    fun kafkaUserCommandHandler(
        commandHandlerDispatcher: CommandHandlerDispatcher,
        mapper: KafkaUserCommandMapper,
    ): KafkaUserCommandHandler {
        return KafkaUserCommandHandler(
            commandHandlerDispatcher,
            mapper
        )
    }

}