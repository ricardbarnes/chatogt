package cat.vonblum.chatogt.usermanagement.producer.config.users.spring

import cat.vonblum.chatogt.shared.domain.event.EventBus
import cat.vonblum.chatogt.shared.domain.generator.IdGenerator
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommandHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringUsersConfig {

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