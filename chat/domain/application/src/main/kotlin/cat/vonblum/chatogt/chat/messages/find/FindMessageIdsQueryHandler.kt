package cat.vonblum.chatogt.chat.messages.find

import cat.vonblum.chatogt.chat.messages.ForFindingMessages
import cat.vonblum.chatogt.chat.shared.ChatId
import cat.vonblum.chatogt.usermanagement.domain.query.QueryHandler

class FindMessageIdsQueryHandler(private val finding: ForFindingMessages) : QueryHandler {

    fun handle(query: FindMessageIdsQuery): FindMessagesResponse =
        FindMessagesResponse(
            query.chatId,
            finding.findAllByChatId(ChatId(query.chatId)).map {
                mapOf(
                    "id" to it.id.value.toString(),
                    "author_id" to it.authorId.value.toString(),
                    "content" to it.content.value,
                )
            }
        )

}