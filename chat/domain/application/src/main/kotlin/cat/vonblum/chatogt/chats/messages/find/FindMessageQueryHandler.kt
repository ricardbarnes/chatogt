package cat.vonblum.chatogt.chats.messages.find

import cat.vonblum.chatogt.chats.messages.FindingMessages
import cat.vonblum.chatogt.chats.messages.MessageId
import cat.vonblum.chatogt.shared.domain.query.QueryHandler

class FindMessageQueryHandler(private val finding: FindingMessages) : QueryHandler {

    fun handle(query: FindMessageQuery): FindMessageResponse =
        FindMessageResponse(
            query.id,
            finding.findById(MessageId(query.id)).content.value
        )

}