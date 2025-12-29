package cat.vonblum.chatogt.usermanagement.consumer.store.shared.mongo

import cat.vonblum.chatogt.usermanagement.consumer.store.shared.WriteStore
import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent

class MongoWriteStore : WriteStore {

    override fun append(event: Event) {
        when (event) {
            is UserCreatedEvent -> append(event)
            else -> throw IllegalArgumentException("event type is not handled")
        }
    }

    private fun append(event: UserCreatedEvent) {
        TODO()
    }

}