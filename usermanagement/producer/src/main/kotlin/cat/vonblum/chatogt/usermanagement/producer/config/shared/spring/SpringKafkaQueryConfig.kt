package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.shared.infrastructure.handler.query.QueryDispatcher
import cat.vonblum.chatogt.usermanagement.producer.handler.query.kafka.KafkaQueryHandler
import cat.vonblum.chatogt.usermanagement.producer.handler.query.kafka.KafkaQueryMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringKafkaQueryConfig {

    @Bean
    fun kafkaQueryMapper(): KafkaQueryMapper {
        return KafkaQueryMapper()
    }

    @Bean
    fun kafkaQueryHandler(
        mapper: KafkaQueryMapper,
        dispatcher: QueryDispatcher
    ): KafkaQueryHandler {
        return KafkaQueryHandler(
            mapper,
            dispatcher,
        )
    }

}
