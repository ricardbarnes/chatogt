package cat.vonblum.chatogt.chat.chats.find

import cat.vonblum.chatogt.usermanagement.domain.query.Response
import java.util.UUID

class FindChatIdsByUserIdResponse(
    val userId: UUID,
    val chatIds: List<UUID>
) : Response