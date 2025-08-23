package cat.vonblum.chatogt.chat.messages.find

import cat.vonblum.chatogt.shared.domain.query.Response
import java.util.UUID

class FindMessageResponse(
    val id: UUID,
    val content: String
) : Response