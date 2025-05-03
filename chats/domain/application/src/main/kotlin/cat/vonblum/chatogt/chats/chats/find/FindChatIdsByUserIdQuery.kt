package cat.vonblum.chatogt.chats.chats.find

import cat.vonblum.chatogt.shared.domain.query.Query
import java.util.UUID

class FindChatIdsByUserIdQuery(val userId: UUID) : Query