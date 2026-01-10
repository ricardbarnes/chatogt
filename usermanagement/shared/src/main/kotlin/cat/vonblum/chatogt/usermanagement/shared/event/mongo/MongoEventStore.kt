package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.domain.valueobject.Id
import cat.vonblum.chatogt.usermanagement.shared.event.EventStore
import cat.vonblum.chatogt.usermanagement.shared.event.shared.ProtoEventDeserializer
import cat.vonblum.chatogt.usermanagement.shared.event.shared.ProtoEventSerializer
import org.springframework.data.mongodb.core.MongoTemplate
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
        TODO()
    }

    override fun load(aggregateId: Id): List<Event> {
        TODO()
    }

}