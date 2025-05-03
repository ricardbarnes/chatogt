package cat.vonblum.chatogt.chats.messages.find

import cat.vonblum.chatogt.shared.domain.query.Query
import java.util.UUID

class FindMessageIdsQuery(val chatId: UUID) : Query