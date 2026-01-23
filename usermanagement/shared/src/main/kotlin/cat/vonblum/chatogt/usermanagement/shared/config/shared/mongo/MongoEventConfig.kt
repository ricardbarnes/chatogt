package cat.vonblum.chatogt.usermanagement.shared.config.shared.mongo

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.shared.event.EventStore
import cat.vonblum.chatogt.usermanagement.shared.event.mongo.MongoEventMapper
import cat.vonblum.chatogt.usermanagement.shared.event.mongo.MongoEventStore
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import kotlin.reflect.KClass

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
        mongoEventCollectionMap: Map<KClass<out Event>, String>
    ): EventStore {
        return MongoEventStore(
            mongoTemplate,
            mongoEventMapper,
            mongoEventCollectionMap
        )
    }

}