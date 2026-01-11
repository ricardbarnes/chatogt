package cat.vonblum.chatogt.usermanagement.shared.config.shared.mongo

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.shared.event.EventStore
import cat.vonblum.chatogt.usermanagement.shared.event.mongo.MongoEventStore
import cat.vonblum.chatogt.usermanagement.shared.event.shared.ProtoEventDeserializer
import cat.vonblum.chatogt.usermanagement.shared.event.shared.ProtoEventSerializer
import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent
import cat.vonblum.chatogt.usermanagement.users.UserDeletedEvent
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import kotlin.reflect.KClass

@Configuration
class MongoEventConfig {

    companion object {

        const val USER_EVENTS_COLLECTION = "userEvents"

    }

    @Bean
    fun protoEventSerializer(): ProtoEventSerializer {
        return ProtoEventSerializer()
    }

    @Bean
    fun protoEventDeserializer(): ProtoEventDeserializer {
        return ProtoEventDeserializer()
    }

    @Bean
    fun mongoEventStore(
        mongoTemplate: MongoTemplate,
        protoEventSerializer: ProtoEventSerializer,
        protoEventDeserializer: ProtoEventDeserializer,
        mongoEventCollectionMap: Map<KClass<out Event>, String>
    ): EventStore {
        return MongoEventStore(
            mongoTemplate,
            protoEventSerializer,
            protoEventDeserializer,
            mongoEventCollectionMap
        )
    }

    @Bean
    fun mongoEventCollectionMap(): Map<KClass<out Event>, String> {
        return mapOf(
            UserCreatedEvent::class to USER_EVENTS_COLLECTION,
            UserDeletedEvent::class to USER_EVENTS_COLLECTION,
        )
    }

}