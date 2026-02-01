package cat.vonblum.chatogt.usermanagement.producer.provider.users.mongo

import cat.vonblum.chatogt.usermanagement.users.port.ForFindingUsers
import cat.vonblum.chatogt.usermanagement.users.model.User
import cat.vonblum.chatogt.usermanagement.users.model.UserEmail
import cat.vonblum.chatogt.usermanagement.users.model.UserId

class MongoForFindingUsers: ForFindingUsers {

    override fun findById(id: UserId): User {
        TODO("Not yet implemented")
    }

    override fun findByEmail(name: UserEmail): User {
        TODO("Not yet implemented")
    }

}