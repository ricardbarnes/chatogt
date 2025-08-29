package cat.vonblum.chatogt.chat.messages.find

import cat.vonblum.chatogt.chat.messages.ForFindingMessages
import cat.vonblum.chatogt.chat.messages.MessageId
import cat.vonblum.chatogt.shared.domain.query.QueryHandler

class FindMessageQueryHandler(private val finding: ForFindingMessages) : QueryHandler {

    fun handle(query: FindMessageQuery): FindMessageResponse =
        FindMessageResponse(
            query.id,
            finding.findById(MessageId(query.id)).content.value
        )

}