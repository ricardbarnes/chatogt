package cat.vonblum.chatogt.usermanagement.shared.store.shared.mongo

import cat.vonblum.chatogt.usermanagement.shared.store.shared.Store
import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.domain.valueobject.Id
import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent

class MongoStore : Store {

    override fun append(event: Event) {
        TODO("Not yet implemented")
    }

    override fun load(aggregateId: Id): List<Event> {
        TODO("Not yet implemented")
    }

    private fun append(event: UserCreatedEvent) {
        TODO("Not yet implemented")
    }

}