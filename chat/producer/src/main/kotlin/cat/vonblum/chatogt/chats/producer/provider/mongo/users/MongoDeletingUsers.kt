package cat.vonblum.chatogt.chats.producer.provider.mongo.users

import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.users.DeletingUsers
import org.springframework.stereotype.Component

@Component
class MongoDeletingUsers : DeletingUsers {

    override fun deleteById(id: UserId) {
        TODO("Not yet implemented")
    }

}