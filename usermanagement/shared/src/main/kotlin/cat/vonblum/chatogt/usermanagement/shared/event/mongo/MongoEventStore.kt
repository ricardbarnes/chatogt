package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.domain.valueobject.Id
import cat.vonblum.chatogt.usermanagement.infrastructure.event.EventStore
import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class MongoEventStore(
    private val template: MongoTemplate,
    private val mapper: MongoEventMapper,
) : EventStore {

    companion object {
        private const val USERS_COLLECTION = "users"
    }

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
                .with(Sort.by(Sort.Direction.ASC, "version")),
            MongoUserCreatedEvent::class.java,
            USERS_COLLECTION
        )

        if (mongoEvents.isEmpty()) {
            return emptyList()
        }

        return mongoEvents.map(mapper::toDomain)
    }

    private fun append(event: UserCreatedEvent) { // TODO: add event streams to control concurrency
        val latestEvent = template.find(
            Query.query(Criteria.where("aggregateId").`is`(event.aggregateId))
                .with(Sort.by(Sort.Direction.DESC, "version"))
                .limit(1),
            MongoUserCreatedEvent::class.java,
            USERS_COLLECTION
        ).firstOrNull()

        val nextVersion = (latestEvent?.version ?: 0L) + 1
        val mongoEvent = mapper.toInfra(event, nextVersion)

        template.insert(mongoEvent, USERS_COLLECTION)
    }

}
