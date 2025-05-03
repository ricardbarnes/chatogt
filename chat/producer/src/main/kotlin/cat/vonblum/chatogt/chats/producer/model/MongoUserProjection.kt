package cat.vonblum.chatogt.chats.producer.model

data class MongoUserProjection(
    val id: String,
    val name: String,
    val contactIds: Set<String>
)