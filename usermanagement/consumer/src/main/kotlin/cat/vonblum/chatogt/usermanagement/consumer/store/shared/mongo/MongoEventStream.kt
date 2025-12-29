package cat.vonblum.chatogt.usermanagement.consumer.store.shared.mongo

import cat.vonblum.chatogt.usermanagement.domain.event.Event

class MongoEventStream(
    val version: Int,
    val events: List<Event>
) // Is this shared (for reads)?