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

    override fun append(event: Event) {
        val collectionName = collectionMap[event::class]
            ?: error("No collection named ${event::class.simpleName} found in collection map")
        val proto = serializer.serialize(event)
    }

    override fun load(aggregateId: Id): List<Event> {
        TODO("Not yet implemented")
    }

}
