package cat.vonblum.chatogt.chats.consumer.store

import cat.vonblum.chatogt.chats.consumer.mapper.MongoMapper
import cat.vonblum.chatogt.shared.domain.event.Event
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Component

@Component
class MongoWriteStore(
    private val mapper: MongoMapper,
    private val mongoTemplate: MongoTemplate
) : WriteStore {

    override fun save(event: Event) {
        mongoTemplate.save(mapper.map(event))
    }

}