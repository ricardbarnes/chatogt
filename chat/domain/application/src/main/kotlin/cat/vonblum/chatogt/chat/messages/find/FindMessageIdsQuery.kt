package cat.vonblum.chatogt.chat.messages.find

import cat.vonblum.chatogt.usermanagement.domain.query.Query
import java.util.UUID

class FindMessageIdsQuery(val chatId: UUID) : Query