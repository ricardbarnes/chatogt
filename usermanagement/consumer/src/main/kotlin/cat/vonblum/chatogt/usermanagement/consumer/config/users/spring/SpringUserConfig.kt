package cat.vonblum.chatogt.usermanagement.consumer.config.users.spring

import cat.vonblum.chatogt.usermanagement.consumer.handler.users.kafka.KafkaUserEventHandler
import cat.vonblum.chatogt.usermanagement.consumer.handler.users.kafka.KafkaUserEventMapper
import cat.vonblum.chatogt.usermanagement.consumer.repository.Projector
import cat.vonblum.chatogt.usermanagement.consumer.repository.PsqlProjector
import cat.vonblum.chatogt.usermanagement.consumer.repository.users.psql.PsqlUserViewMapper
import cat.vonblum.chatogt.usermanagement.consumer.repository.users.psql.PsqlUserViewRepository
import cat.vonblum.chatogt.usermanagement.infrastructure.event.EventStore
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringUserConfig {

    @Bean
    fun kafkaUserEventMapper(): KafkaUserEventMapper {
        return KafkaUserEventMapper()
    }

    @Bean
    fun psqlUserViewRepository(): PsqlUserViewRepository {
        return PsqlUserViewRepository()
    }

    @Bean
    fun psqlUserViewMapper(): PsqlUserViewMapper {
        return PsqlUserViewMapper()
    }

    @Bean
    fun psqlProjector(
        psqlUserViewRepository: PsqlUserViewRepository,
        psqlUserViewMapper: PsqlUserViewMapper
    ): Projector {
        return PsqlProjector(
            psqlUserViewRepository,
            psqlUserViewMapper
        )
    }

    @Bean
    fun kafkaUserEventHandler(
        eventStore: EventStore,
        projector: Projector,
        kafkaUserEventMapper: KafkaUserEventMapper
    ): KafkaUserEventHandler {
        return KafkaUserEventHandler(
            eventStore,
            projector,
            kafkaUserEventMapper
        )
    }

}