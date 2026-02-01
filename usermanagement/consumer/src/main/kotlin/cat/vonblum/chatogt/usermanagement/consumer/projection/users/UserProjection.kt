package cat.vonblum.chatogt.usermanagement.consumer.projection.users

import cat.vonblum.chatogt.usermanagement.users.event.UserCreatedEvent

interface UserProjection {

    fun apply(event: UserCreatedEvent)

}