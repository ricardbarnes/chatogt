package cat.vonblum.chatogt.chat.chats.create

import cat.vonblum.chatogt.chat.chats.Chat
import cat.vonblum.chatogt.chat.shared.ChatId
import cat.vonblum.chatogt.chat.shared.UserId
import cat.vonblum.chatogt.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.shared.domain.event.EventBus
import cat.vonblum.chatogt.shared.domain.generator.IdGenerator

class CreateChatCommandHandler(
    private val eventBus: EventBus,
    private val idGenerator: IdGenerator,
) : CommandHandler {

    fun handle(command: CreateChatCommand) = Chat.create(
        ChatId(idGenerator.next()),
        command.participantIds.map { UserId(it) }.toMutableSet(),
    ).let { chat ->
        eventBus.publish(chat.pullEvents())
    }

}