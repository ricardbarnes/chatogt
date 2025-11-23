package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.usermanagement.infrastructure.handler.command.CommandDispatcher
import cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka.KafkaUserCommandHandler
import cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka.KafkaUserCommandMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringKafkaCommandConfig {

    @Bean
    fun kafkaCommandMapper(): KafkaUserCommandMapper {
        return KafkaUserCommandMapper()
    }

    @Bean
    fun kafkaCommandHandler(
        mapper: KafkaUserCommandMapper,
        dispatcher: CommandDispatcher
    ): KafkaUserCommandHandler {
        return KafkaUserCommandHandler(
            mapper,
            dispatcher,
        )
    }

}
