package cat.vonblum.chatogt.chat.producer.provider.users.mongo

data class MongoUserProjection(
    val id: String,
    val name: String,
    val contactIds: Set<String>
)