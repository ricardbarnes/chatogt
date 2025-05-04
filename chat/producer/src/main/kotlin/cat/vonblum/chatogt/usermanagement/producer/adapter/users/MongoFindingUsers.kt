package cat.vonblum.chatogt.usermanagement.producer.adapter.users

import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.users.DeletingUsers
import cat.vonblum.chatogt.shared.infrastructure.annotation.DrivenAdapter
import org.springframework.stereotype.Component

@DrivenAdapter
@Component
class MongoFindingUsers : DeletingUsers {

    override fun deleteById(id: UserId) {
        TODO("Not yet implemented")
    }
    
}