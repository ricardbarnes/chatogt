package cat.vonblum.chatogt.chat.api.controller.messages.rest

import java.util.UUID

class RestMessageDto(
    val id: UUID?,
    val chatId: UUID,
    val authorId: UUID,
    val content: String
)