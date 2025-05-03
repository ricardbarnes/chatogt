package cat.vonblum.chatogt.users.producer.adapter.users

import cat.vonblum.chatogt.shared.infrastructure.annotation.DrivenAdapter
import cat.vonblum.chatogt.users.users.StoringUsers
import cat.vonblum.chatogt.users.users.User
import org.springframework.stereotype.Component

@DrivenAdapter
@Component
class MongoStoringUsers : StoringUsers {

    override fun save(user: User) {
        TODO("Not yet implemented")
    }

}