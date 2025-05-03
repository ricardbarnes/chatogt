package cat.vonblum.chatogt.chats.messages.update

import cat.vonblum.chatogt.chats.messages.FindingMessages
import cat.vonblum.chatogt.chats.messages.MessageContent
import cat.vonblum.chatogt.chats.messages.MessageId
import cat.vonblum.chatogt.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.shared.domain.event.EventBus

class UpdateMessageCommandHandler(
    private val finding: FindingMessages,
    private val eventBus: EventBus
) : CommandHandler {

    fun handle(command: UpdateMessageCommand) = finding.findById(MessageId(command.id)).let { message ->
        message.update(MessageContent(command.content))
        eventBus.publish(message.pullEvents())
    }

}