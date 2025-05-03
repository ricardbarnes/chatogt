package cat.vonblum.chatogt.chats.chats.delete

import cat.vonblum.chatogt.chats.chats.FindingChats
import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.shared.domain.event.EventBus

class DeleteChatCommandHandler(
    private val finding: FindingChats,
    private val eventBus: EventBus
) : CommandHandler {

    fun handle(command: DeleteChatCommand) = finding.findById(ChatId(command.id)).let { chat ->
        chat.delete()
        eventBus.publish(chat.pullEvents())
    }

}