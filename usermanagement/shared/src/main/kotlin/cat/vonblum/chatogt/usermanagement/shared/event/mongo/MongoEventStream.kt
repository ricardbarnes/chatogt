package cat.vonblum.chatogt.usermanagement.shared.event.mongo

class MongoEventStream(
    val version: Int,
    val events: List<MongoEvent>
)