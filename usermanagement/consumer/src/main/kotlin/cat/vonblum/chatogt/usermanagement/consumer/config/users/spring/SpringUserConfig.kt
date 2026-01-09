package cat.vonblum.chatogt.usermanagement.consumer.config.users.spring

import cat.vonblum.chatogt.usermanagement.consumer.handler.users.kafka.KafkaUserEventHandler
import cat.vonblum.chatogt.usermanagement.consumer.handler.users.kafka.KafkaUserEventMapper
import cat.vonblum.chatogt.usermanagement.consumer.projection.users.UserProjection
import cat.vonblum.chatogt.usermanagement.consumer.projection.users.mongo.MongoUserProjection
import cat.vonblum.chatogt.usermanagement.consumer.repository.users.UserRepository
import cat.vonblum.chatogt.usermanagement.consumer.repository.users.mongo.MongoUserRepository
import cat.vonblum.chatogt.usermanagement.shared.event.EventStore
import cat.vonblum.chatogt.usermanagement.shared.event.mongo.MongoEventStore
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
        return MongoUserRepository()
    }

    @Bean
    fun mongoUserProjection(
        mongoUserRepository: UserRepository
    ): UserProjection {
        return MongoUserProjection(
            mongoUserRepository,
        )
    }

    @Bean
    fun mongoWriteStore(): EventStore {
        return MongoEventStore()
    }

    @Bean
    fun kafkaUserEventHandler(
        kafkaUserEventMapper: KafkaUserEventMapper,
        mongoStore: EventStore,
        mongoUserProjection: UserProjection
    ): KafkaUserEventHandler {
        return KafkaUserEventHandler(
            kafkaUserEventMapper,
            mongoStore,
            mongoUserProjection
        )
    }

}