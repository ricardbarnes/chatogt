package cat.vonblum.chatogt.usermanagement.producer.adapter.users

import cat.vonblum.chatogt.usermanagement.users.StoringUsers
import cat.vonblum.chatogt.usermanagement.users.User
import org.springframework.stereotype.Component

@Component
class MongoStoringUsers : StoringUsers {

    override fun save(user: User) {
        TODO("Not yet implemented")
    }

}