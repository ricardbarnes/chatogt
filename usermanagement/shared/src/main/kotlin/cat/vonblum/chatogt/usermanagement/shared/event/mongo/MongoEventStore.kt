package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.domain.valueobject.Id
import cat.vonblum.chatogt.usermanagement.shared.event.EventStore
import cat.vonblum.chatogt.usermanagement.shared.event.shared.ProtoEventDeserializer
import cat.vonblum.chatogt.usermanagement.shared.event.shared.ProtoEventSerializer
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import java.util.UUID
import kotlin.reflect.KClass

class MongoEventStore(
    private val template: MongoTemplate,
    private val serializer: ProtoEventSerializer,
    private val deserializer: ProtoEventDeserializer,
    private val collectionMap: Map<KClass<out Event>, String>
) : EventStore {

    override fun append(
        aggregateId: Id,
        expectedVersion: Int,
        events: Collection<Event>
    ) {
        if (events.isEmpty()) {
            return
        }

        val eventClass = events.first()::class
        val collection = collectionMap[eventClass]
            ?: error("No collection mapped for event type $eventClass")
        // Optimistic locking
        val lastEvent = template.findOne(
            Query(Criteria.where("aggregateId").`is`(aggregateId.value))
                .with(Sort.by(Sort.Direction.DESC, "version"))
                .limit(1),
            MongoEvent::class.java,
            collection
        )

        val currentVersion = lastEvent?.version ?: 0L
        if (currentVersion != expectedVersion.toLong()) {
            error(
                "Concurrency conflict for aggregate ${aggregateId.value}. " +
                        "Expected version $expectedVersion but was $currentVersion"
            )
        }

        var version = currentVersion
        events.forEach { event ->
            version++
            val document = MongoEvent(
                UUID.randomUUID(),
                aggregateId.value,
                event::class.qualifiedName
                    ?: error("Anonymous aggregate type"),
                version,
                event::class.qualifiedName
                    ?: error("Anonymous event type"),
                serializer.serialize(event),
                event.occurredOn
            )

            template.insert(document, collection)
        }
    }

    override fun load(aggregateId: Id): List<Event> {
        val mongoEvents = collectionMap.values
            .distinct()
            .flatMap { collection ->
                template.find(
                    Query(Criteria.where("aggregateId").`is`(aggregateId.value))
                        .with(Sort.by(Sort.Direction.ASC, "version")),
                    MongoEvent::class.java,
                    collection
                )
            }
            .sortedBy { it.version }

        return mongoEvents.map(deserializer::deserialize)
    }

}
