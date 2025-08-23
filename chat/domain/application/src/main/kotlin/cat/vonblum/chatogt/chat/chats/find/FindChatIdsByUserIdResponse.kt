package cat.vonblum.chatogt.chat.chats.find

import cat.vonblum.chatogt.shared.domain.query.Response
import java.util.UUID

class FindChatIdsByUserIdResponse(
    val userId: UUID,
    val chatIds: List<UUID>
) : Response