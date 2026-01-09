package cat.vonblum.chatogt.usermanagement.shared.store.shared.mongo

class MongoEventStream(
    val version: Int,
    val events: List<MongoEvent>
)