package cat.vonblum.chatogt.usermanagement.shared.config

import cat.vonblum.chatogt.usermanagement.infrastructure.event.EventStore
import cat.vonblum.chatogt.usermanagement.shared.event.mongo.MongoEventMapper
import cat.vonblum.chatogt.usermanagement.shared.event.mongo.MongoEventStore
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate

@Configuration
class MongoEventConfig {

    @Bean
    fun mongoEventMapper(): MongoEventMapper {
        return MongoEventMapper()
    }

    @Bean
    fun mongoEventStore(
        mongoTemplate: MongoTemplate,
        mongoEventMapper: MongoEventMapper,
    ): EventStore {
        return MongoEventStore(
            mongoTemplate,
            mongoEventMapper
        )
    }

}