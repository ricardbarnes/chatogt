package cat.vonblum.chatogt.chat.chats.find

import cat.vonblum.chatogt.shared.domain.query.Response
import java.util.UUID

class FindChatResponse(
    val id: UUID,
    val participantIds: List<UUID>
) : Response