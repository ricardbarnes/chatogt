package cat.vonblum.chatogt.usermanagement.consumer.projection.users.mongo

import cat.vonblum.chatogt.usermanagement.consumer.projection.users.UserProjection
import cat.vonblum.chatogt.usermanagement.consumer.repository.users.UserRepository
import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent

class MongoUserProjection(
    private val repository: UserRepository
) : UserProjection {

    override fun apply(event: UserCreatedEvent) {
        println("event for ${event.email} has been applied to projection")
    }

}