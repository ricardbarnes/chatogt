package cat.vonblum.chatogt.chat.chats.update

import cat.vonblum.chatogt.chat.chats.ForFindingChats
import cat.vonblum.chatogt.chat.shared.ChatId
import cat.vonblum.chatogt.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.shared.domain.event.EventBus

class UpdateChatCommandHandler(
    private val finding: ForFindingChats,
    private val eventBus: EventBus
) : CommandHandler {

    fun handle(command: UpdateChatCommand) = finding.findById(ChatId(command.id)).let { chat ->
        chat.mute()
        eventBus.publish(chat.pullEvents())
    }

}