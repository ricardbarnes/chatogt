package cat.vonblum.chatogt.chat.producer.provider.mongo.users

import cat.vonblum.chatogt.chat.users.ForFindingUsers
import cat.vonblum.chatogt.chat.users.User
import cat.vonblum.chatogt.chat.users.UserName
import org.springframework.stereotype.Component

@Component
class MongoForFindingUsers : ForFindingUsers {

    override fun findByName(name: UserName): User {
        TODO("Not yet implemented")
    }

}