package cat.vonblum.chatogt.chats.producer.repository.impl

import cat.vonblum.chatogt.chats.producer.mapper.MongoUserMapper
import cat.vonblum.chatogt.chats.producer.model.MongoUserProjection
import cat.vonblum.chatogt.chats.producer.repository.UserRepository
import cat.vonblum.chatogt.chats.infrastructure.model.MongoUserCreatedEvent
import cat.vonblum.chatogt.chats.users.User
import cat.vonblum.chatogt.chats.users.UserName
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

@Repository
internal class MongoUserRepository(
    private val template: MongoTemplate,
    private val mapper: MongoUserMapper
) : UserRepository {

    override fun findByName(name: UserName): User {
        val query = Query().addCriteria(Criteria.where("name").`is`(name.value))
        val projection = template.findOne(
            query,
            MongoUserProjection::class.java,
            template.getCollectionName(MongoUserCreatedEvent::class.java)
        )
        return projection.let { mapper.map(it!!) }
    }

}