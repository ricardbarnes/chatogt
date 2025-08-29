package cat.vonblum.chatogt.chat.chats.find

import cat.vonblum.chatogt.chat.chats.ForFindingChats
import cat.vonblum.chatogt.chat.shared.UserId
import cat.vonblum.chatogt.shared.domain.query.QueryHandler

class FindChatIdsByUserIdQueryHandler(private val finding: ForFindingChats) : QueryHandler {

    fun handle(query: FindChatIdsByUserIdQuery) =
        FindChatIdsByUserIdResponse(
            query.userId,
            finding.findAllIdsByUserId(UserId(query.userId)).stream().map { it.value }.toList()
        )

}