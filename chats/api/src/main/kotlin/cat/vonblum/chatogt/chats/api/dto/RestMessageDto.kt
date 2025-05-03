package cat.vonblum.chatogt.chats.api.dto

import java.util.UUID

class RestMessageDto(
    val id: UUID?,
    val chatId: UUID,
    val authorId: UUID,
    val content: String
)