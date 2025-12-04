package cat.vonblum.chatogt.usermanagement.producer.provider.users.mongo

import cat.vonblum.chatogt.usermanagement.users.ForFindingUsers
import cat.vonblum.chatogt.usermanagement.users.User
import cat.vonblum.chatogt.usermanagement.users.UserEmail
import cat.vonblum.chatogt.usermanagement.users.UserId

class MongoForFindingUsers: ForFindingUsers {

    override fun findById(id: UserId): User {
        TODO("Not yet implemented")
    }

    override fun findByEmail(name: UserEmail): User {
        TODO("Not yet implemented")
    }

}