package cat.vonblum.chatogt.usermanagement.producer.adapter.users

import cat.vonblum.chatogt.usermanagement.users.DeletingUsers
import cat.vonblum.chatogt.usermanagement.users.UserId
import org.springframework.stereotype.Component

@Component
class MongoFindingUsers : DeletingUsers {

    override fun deleteById(id: UserId) {
        TODO("Not yet implemented")
    }
    
}