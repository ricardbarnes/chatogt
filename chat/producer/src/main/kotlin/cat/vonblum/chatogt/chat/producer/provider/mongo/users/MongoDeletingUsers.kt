package cat.vonblum.chatogt.chat.producer.provider.mongo.users

import cat.vonblum.chatogt.chat.shared.UserId
import cat.vonblum.chatogt.chat.users.DeletingUsers
import org.springframework.stereotype.Component

@Component
class MongoDeletingUsers : DeletingUsers {

    override fun deleteById(id: UserId) {
        TODO("Not yet implemented")
    }

}