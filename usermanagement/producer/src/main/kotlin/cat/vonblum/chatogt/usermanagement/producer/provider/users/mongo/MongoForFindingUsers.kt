package cat.vonblum.chatogt.usermanagement.producer.provider.users.mongo

import cat.vonblum.chatogt.usermanagement.users.port.ForFindingUsers
import cat.vonblum.chatogt.usermanagement.users.aggregate.User
import cat.vonblum.chatogt.usermanagement.users.aggregate.UserEmail
import cat.vonblum.chatogt.usermanagement.users.aggregate.UserId

class MongoForFindingUsers: ForFindingUsers {

    override fun findById(id: UserId): User {
        TODO("Not yet implemented")
    }

    override fun findByEmail(name: UserEmail): User {
        TODO("Not yet implemented")
    }

}