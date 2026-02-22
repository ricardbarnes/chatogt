package cat.vonblum.chatogt.usermanagement.consumer.config.users.spring

import cat.vonblum.chatogt.usermanagement.consumer.handler.users.kafka.KafkaUserEventHandler
import cat.vonblum.chatogt.usermanagement.consumer.handler.users.kafka.KafkaUserEventMapper
import cat.vonblum.chatogt.usermanagement.consumer.view.users.UserView
import cat.vonblum.chatogt.usermanagement.consumer.view.users.mongo.MongoUserView
import cat.vonblum.chatogt.usermanagement.consumer.repository.users.UserRepository
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
    fun mongoUserRepository(): UserRepository {
        return PsqlUserViewRepository()
    }

    @Bean
    fun mongoUserProjection(
        mongoUserRepository: UserRepository
    ): UserView {
        return MongoUserView(
            mongoUserRepository,
        )
    }

    @Bean
    fun kafkaUserEventHandler(
        kafkaUserEventMapper: KafkaUserEventMapper,
        mongoStore: EventStore,
        mongoUserProjection: UserView
    ): KafkaUserEventHandler {
        return KafkaUserEventHandler(
            kafkaUserEventMapper,
            mongoStore,
            mongoUserProjection
        )
    }

}