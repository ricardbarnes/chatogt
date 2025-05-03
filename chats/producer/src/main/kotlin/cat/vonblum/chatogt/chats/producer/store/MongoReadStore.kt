package cat.vonblum.chatogt.chats.producer.store

import cat.vonblum.chatogt.chats.chats.ChatCreatedEvent
import cat.vonblum.chatogt.chats.producer.mapper.MongoEventMapper
import cat.vonblum.chatogt.shared.domain.event.Event
import cat.vonblum.chatogt.shared.domain.valueobject.Id
import cat.vonblum.chatogt.chats.infrastructure.model.MongoEvent
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
internal class MongoReadStore(
    private val template: MongoTemplate,
    private val mapper: MongoEventMapper,
) : ReadStore {

    override fun findAll(type: Class<out Event>, aggregateId: Id): List<Event> {
        val idFieldName = aggregateId::class.simpleName ?: throw IllegalArgumentException("$type is not defined")
        val query = Query()
        query.addCriteria(Criteria.where(idFieldName).`is`(aggregateId.value))
        val mongoType = getMongoType(type)
        return mapper.map(template.find(query, mongoType))
    }

    private fun getMongoType(type: Class<out Event>): Class<out MongoEvent> {
        return when (type) { // TODO
            ChatCreatedEvent::class.java -> MongoEvent::class.java
            else -> throw IllegalArgumentException("type must be a chat created event")
        }
    }

}