package cat.vonblum.chatogt.chat.chats.find

import cat.vonblum.chatogt.chat.chats.FindingChats
import cat.vonblum.chatogt.chat.shared.ChatId
import cat.vonblum.chatogt.shared.domain.query.QueryHandler

class FindChatQueryHandler(private val finding: FindingChats) : QueryHandler {

    fun handle(query: FindChatQuery): FindChatResponse =
        finding.findById(ChatId(query.id)).let { chat ->
            FindChatResponse(
                chat.id.value,
                chat.participantIds.map { it.value }
            )
        }

}