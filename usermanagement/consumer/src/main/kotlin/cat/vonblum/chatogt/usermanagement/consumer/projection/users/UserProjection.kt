package cat.vonblum.chatogt.usermanagement.consumer.projection.users

import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent

interface UserProjection {

    fun apply(event: UserCreatedEvent)

}