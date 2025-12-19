package cat.vonblum.chatogt.usermanagement.consumer.store.users

import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent

interface UserStore {

    fun store(event: UserCreatedEvent)

}