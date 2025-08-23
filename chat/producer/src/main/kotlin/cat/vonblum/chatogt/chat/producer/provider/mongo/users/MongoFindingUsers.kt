package cat.vonblum.chatogt.chat.producer.provider.mongo.users

import cat.vonblum.chatogt.chat.users.FindingUsers
import cat.vonblum.chatogt.chat.users.User
import cat.vonblum.chatogt.chat.users.UserName
import org.springframework.stereotype.Component

@Component
class MongoFindingUsers : FindingUsers {

    override fun findByName(name: UserName): User {
        TODO("Not yet implemented")
    }

}