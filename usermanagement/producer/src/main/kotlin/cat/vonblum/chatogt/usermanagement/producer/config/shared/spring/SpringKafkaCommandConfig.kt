package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.usermanagement.infrastructure.handler.command.CommandDispatcher
import cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka.KafkaUserCommandHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringKafkaCommandConfig {


    @Bean
    fun kafkaCommandHandler(
        dispatcher: CommandDispatcher
    ): KafkaUserCommandHandler {
        return KafkaUserCommandHandler(dispatcher)
    }

}
