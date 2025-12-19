package cat.vonblum.chatogt.usermanagement.consumer.config.users.spring

import cat.vonblum.chatogt.usermanagement.consumer.handler.users.kafka.KafkaUserEventHandler
import cat.vonblum.chatogt.usermanagement.consumer.handler.users.kafka.KafkaUserEventMapper
import cat.vonblum.chatogt.usermanagement.consumer.projection.users.UserProjection
import cat.vonblum.chatogt.usermanagement.consumer.projection.users.mongo.MongoUserProjection
import cat.vonblum.chatogt.usermanagement.consumer.repository.users.UserRepository
import cat.vonblum.chatogt.usermanagement.consumer.repository.users.mongo.MongoUserRepository
import cat.vonblum.chatogt.usermanagement.consumer.store.users.UserStore
import cat.vonblum.chatogt.usermanagement.consumer.store.users.mongo.MongoUserStore
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringUserConfig {

    @Bean
    fun kafkaUserEventMapper(): KafkaUserEventMapper {
        return KafkaUserEventMapper()
    }

    @Bean
    fun mongoUserStore(): UserStore {
        return MongoUserStore()
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
    fun kafkaUserEventHandler(
        kafkaUserEventMapper: KafkaUserEventMapper,
        mongoUserStore: UserStore,
        mongoUserProjection: UserProjection
    ): KafkaUserEventHandler {
        return KafkaUserEventHandler(
            kafkaUserEventMapper,
            mongoUserStore,
            mongoUserProjection
        )
    }

}