package cat.vonblum.chatogt.chats.chats.find

import cat.vonblum.chatogt.chats.chats.FindingChats
import cat.vonblum.chatogt.chats.shared.ChatId
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