package cat.vonblum.chatogt.chats.producer.provider.mongo.users

data class MongoUserProjection(
    val id: String,
    val name: String,
    val contactIds: Set<String>
)