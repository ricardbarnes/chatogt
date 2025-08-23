package cat.vonblum.chatogt.chat.producer.provider.mongo.users

data class MongoUserProjection(
    val id: String,
    val name: String,
    val contactIds: Set<String>
)