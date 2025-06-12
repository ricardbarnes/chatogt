package cat.vonblum.chatogt.chats.producer.adapter.users.driven

data class MongoUserProjection(
    val id: String,
    val name: String,
    val contactIds: Set<String>
)