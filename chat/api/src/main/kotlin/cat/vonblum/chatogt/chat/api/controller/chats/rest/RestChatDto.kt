package cat.vonblum.chatogt.chat.api.controller.chats.rest

import java.util.UUID

class RestChatDto(
    val id: UUID?,
    val participantIds: List<UUID>
)