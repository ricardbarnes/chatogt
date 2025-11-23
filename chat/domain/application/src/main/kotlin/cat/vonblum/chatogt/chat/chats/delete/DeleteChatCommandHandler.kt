package cat.vonblum.chatogt.chat.chats.delete

import cat.vonblum.chatogt.chat.chats.ForFindingChats
import cat.vonblum.chatogt.chat.shared.ChatId
import cat.vonblum.chatogt.usermanagement.domain.command.CommandHandler
import cat.vonblum.chatogt.usermanagement.domain.event.EventBus

class DeleteChatCommandHandler(
    private val finding: ForFindingChats,
    private val eventBus: EventBus
) : CommandHandler {

    fun handle(command: DeleteChatCommand) = finding.findById(ChatId(command.id)).let { chat ->
        chat.delete()
        eventBus.publish(chat.pullEvents())
    }

}