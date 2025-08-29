package cat.vonblum.chatogt.chat.chats.find

import cat.vonblum.chatogt.chat.chats.ForFindingChats
import cat.vonblum.chatogt.chat.shared.ChatId
import cat.vonblum.chatogt.shared.domain.query.QueryHandler

class FindChatQueryHandler(private val finding: ForFindingChats) : QueryHandler {

    fun handle(query: FindChatQuery): FindChatResponse =
        finding.findById(ChatId(query.id)).let { chat ->
            FindChatResponse(
                chat.id.value,
                chat.participantIds.map { it.value }
            )
        }

}