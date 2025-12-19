package cat.vonblum.chatogt.usermanagement.consumer.store.users.mongo

import cat.vonblum.chatogt.usermanagement.consumer.store.users.UserStore
import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent

class MongoUserStore : UserStore {

    override fun store(event: UserCreatedEvent) {
        println("creation event for ${event.email} has been stored")
    }

}