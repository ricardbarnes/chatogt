package cat.vonblum.chatogt.chat.messages.find

import cat.vonblum.chatogt.chat.messages.FindingMessages
import cat.vonblum.chatogt.chat.shared.ChatId
import cat.vonblum.chatogt.shared.domain.query.QueryHandler

class FindMessageIdsQueryHandler(private val finding: FindingMessages) : QueryHandler {

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