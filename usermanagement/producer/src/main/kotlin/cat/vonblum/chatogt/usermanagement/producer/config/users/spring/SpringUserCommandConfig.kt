package cat.vonblum.chatogt.usermanagement.producer.config.users.spring

import cat.vonblum.chatogt.usermanagement.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.domain.generator.IdGenerator
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommandHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

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

}