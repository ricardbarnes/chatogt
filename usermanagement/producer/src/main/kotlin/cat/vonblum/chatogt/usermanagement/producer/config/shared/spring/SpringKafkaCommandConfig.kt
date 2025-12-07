package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.usermanagement.domain.command.Command
import cat.vonblum.chatogt.usermanagement.domain.command.CommandHandler
import cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka.KafkaUserCommandHandler
import cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka.KafkaUserCommandMapper
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommandHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.reflect.KClass

@Configuration
class SpringKafkaCommandConfig {

    @Bean
    fun kafkaUserCommandMapper(): KafkaUserCommandMapper {
        return KafkaUserCommandMapper()
    }

    @Bean
    fun userHandlerMap(
        createUserCommandHandler: CreateUserCommandHandler,
        // add further command handlers upon here
    ): Map<KClass<out Command>, CommandHandler> {
        return mapOf(
            CreateUserCommand::class as KClass<out Command> to createUserCommandHandler as CommandHandler,
            // add further command to handler mappings upon here
        )
    }

    @Bean
    fun kafkaUserCommandHandler(
        userHandlerMap: Map<KClass<out Command>, CommandHandler>,
        mapper: KafkaUserCommandMapper,
    ): KafkaUserCommandHandler {
        return KafkaUserCommandHandler(
            userHandlerMap,
            mapper
        )
    }

}
