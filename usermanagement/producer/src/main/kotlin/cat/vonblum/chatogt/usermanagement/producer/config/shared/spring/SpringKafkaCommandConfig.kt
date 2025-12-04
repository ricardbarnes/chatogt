package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.usermanagement.infrastructure.handler.command.CommandDispatcher
import cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka.KafkaUserCommandHandler
import cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka.KafkaUserCommandMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringKafkaCommandConfig {

    @Bean
    fun kafkaUserCommandMapper(): KafkaUserCommandMapper {
        return KafkaUserCommandMapper()
    }

    @Bean
    fun kafkaUserCommandHandler(
        dispatcher: CommandDispatcher,
        mapper: KafkaUserCommandMapper,
    ): KafkaUserCommandHandler {
        return KafkaUserCommandHandler(
            dispatcher,
            mapper
        )
    }

}
