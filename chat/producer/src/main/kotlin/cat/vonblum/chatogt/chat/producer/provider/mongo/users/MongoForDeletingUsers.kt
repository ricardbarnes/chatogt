package cat.vonblum.chatogt.chat.producer.provider.mongo.users

import cat.vonblum.chatogt.chat.shared.UserId
import cat.vonblum.chatogt.chat.users.ForDeletingUsers
import org.springframework.stereotype.Component

@Component
class MongoForDeletingUsers : ForDeletingUsers {

    override fun deleteById(id: UserId) {
        TODO("Not yet implemented")
    }

}