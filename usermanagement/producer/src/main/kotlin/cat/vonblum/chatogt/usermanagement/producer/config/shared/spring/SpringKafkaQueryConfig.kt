package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.usermanagement.infrastructure.handler.query.QueryDispatcher
import cat.vonblum.chatogt.usermanagement.producer.handler.query.users.kafka.KafkaUserQueryHandler
import cat.vonblum.chatogt.usermanagement.producer.handler.query.users.kafka.KafkaUserQueryMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringKafkaQueryConfig {

    @Bean
    fun kafkaQueryMapper(): KafkaUserQueryMapper {
        return KafkaUserQueryMapper()
    }

    @Bean
    fun kafkaQueryHandler(
        mapper: KafkaUserQueryMapper,
        dispatcher: QueryDispatcher
    ): KafkaUserQueryHandler {
        return KafkaUserQueryHandler(
            mapper,
            dispatcher,
        )
    }

}
