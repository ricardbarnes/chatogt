package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.shared.infrastructure.handler.command.CommandDispatcher
import cat.vonblum.chatogt.usermanagement.producer.handler.command.kafka.KafkaCommandHandler
import cat.vonblum.chatogt.usermanagement.producer.handler.command.kafka.KafkaCommandMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringKafkaCommandConfig {

    @Bean
    fun kafkaCommandMapper(): KafkaCommandMapper {
        return KafkaCommandMapper()
    }

    @Bean
    fun kafkaCommandHandler(
        mapper: KafkaCommandMapper,
        dispatcher: CommandDispatcher
    ): KafkaCommandHandler {
        return KafkaCommandHandler(
            mapper,
            dispatcher,
        )
    }

}
