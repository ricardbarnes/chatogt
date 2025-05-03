package cat.vonblum.chatogt.chats.chats.update

import cat.vonblum.chatogt.chats.chats.FindingChats
import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.shared.domain.event.EventBus

class UpdateChatCommandHandler(
    private val finding: FindingChats,
    private val eventBus: EventBus
) : CommandHandler {

    fun handle(command: UpdateChatCommand) = finding.findById(ChatId(command.id)).let { chat ->
        chat.mute()
        eventBus.publish(chat.pullEvents())
    }

}