package cat.vonblum.chatogt.chats.producer.adapter.users

import cat.vonblum.chatogt.chats.users.FindingUsers
import cat.vonblum.chatogt.chats.users.User
import cat.vonblum.chatogt.chats.users.UserName
import org.springframework.stereotype.Component

@Component
class MongoFindingUsers : FindingUsers {

    override fun findByName(name: UserName): User {
        TODO("Not yet implemented")
    }

}