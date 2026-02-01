package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.domain.valueobject.Id
import cat.vonblum.chatogt.usermanagement.infrastructure.event.EventStore
import cat.vonblum.chatogt.usermanagement.shared.event.mongo.MongoEvent.Companion.USERS_COLLECTION
import cat.vonblum.chatogt.usermanagement.users.event.UserCreatedEvent
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class MongoEventStore(
    private val template: MongoTemplate,
    private val mapper: MongoEventMapper,
) : EventStore {

    override fun append(event: Event) {
        when (event) {
            is UserCreatedEvent -> append(event)
            else -> throw IllegalArgumentException(
                "event type not recognized: ${event::class}"
            )
        }
    }

    override fun load(aggregateId: Id): List<Event> {
        val mongoEvents = template.find(
            Query.query(Criteria.where("aggregateId").`is`(aggregateId.value))
                .with(Sort.by(Sort.Direction.ASC, "aggregateVersion")),
            MongoUserCreatedEvent::class.java,
            USERS_COLLECTION
        )

        if (mongoEvents.isEmpty()) {
            return emptyList()
        }

        return mongoEvents.map(mapper::toDomain)
    }

    private fun append(event: UserCreatedEvent) {
        val mongoEvent = mapper.toInfra(event)
        template.insert(mongoEvent, USERS_COLLECTION)
    }

}
