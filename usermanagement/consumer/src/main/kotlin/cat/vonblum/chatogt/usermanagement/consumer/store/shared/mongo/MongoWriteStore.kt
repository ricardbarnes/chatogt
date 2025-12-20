package cat.vonblum.chatogt.usermanagement.consumer.store.shared.mongo

import cat.vonblum.chatogt.usermanagement.consumer.store.shared.WriteStore
import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent

class MongoWriteStore : WriteStore {

    override fun store(event: Event) {
        when (event) {
            is UserCreatedEvent -> store(event)
            else -> throw IllegalArgumentException("event type is not handled")
        }
    }

    private fun store(event: UserCreatedEvent) {
        TODO()
    }

}