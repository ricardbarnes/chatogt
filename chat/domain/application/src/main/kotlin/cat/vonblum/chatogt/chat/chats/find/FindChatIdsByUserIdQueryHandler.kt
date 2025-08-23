package cat.vonblum.chatogt.chat.chats.find

import cat.vonblum.chatogt.chat.chats.FindingChats
import cat.vonblum.chatogt.chat.shared.UserId
import cat.vonblum.chatogt.shared.domain.query.QueryHandler

class FindChatIdsByUserIdQueryHandler(private val finding: FindingChats) : QueryHandler {

    fun handle(query: FindChatIdsByUserIdQuery) =
        FindChatIdsByUserIdResponse(
            query.userId,
            finding.findAllIdsByUserId(UserId(query.userId)).stream().map { it.value }.toList()
        )

}