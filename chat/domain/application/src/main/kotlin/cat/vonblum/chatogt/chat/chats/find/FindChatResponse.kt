package cat.vonblum.chatogt.chat.chats.find

import cat.vonblum.chatogt.usermanagement.domain.query.Response
import java.util.UUID

class FindChatResponse(
    val id: UUID,
    val participantIds: List<UUID>
) : Response