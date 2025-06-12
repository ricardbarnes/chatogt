package cat.vonblum.chatogt.usermanagement.producer.adapter.users.driven

import cat.vonblum.chatogt.usermanagement.users.DeletingUsers
import cat.vonblum.chatogt.usermanagement.users.UserId
import org.springframework.stereotype.Component

@Component
class MongoDeletingUsers : DeletingUsers {

    override fun deleteById(id: UserId) {
        TODO("Not yet implemented")
    }

}