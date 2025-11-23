package cat.vonblum.chatogt.chat.messages.update

import cat.vonblum.chatogt.chat.messages.ForFindingMessages
import cat.vonblum.chatogt.chat.messages.MessageContent
import cat.vonblum.chatogt.chat.messages.MessageId
import cat.vonblum.chatogt.usermanagement.domain.command.CommandHandler
import cat.vonblum.chatogt.usermanagement.domain.event.EventBus

class UpdateMessageCommandHandler(
    private val finding: ForFindingMessages,
    private val eventBus: EventBus
) : CommandHandler {

    fun handle(command: UpdateMessageCommand) = finding.findById(MessageId(command.id)).let { message ->
        message.update(MessageContent(command.content))
        eventBus.publish(message.pullEvents())
    }

}