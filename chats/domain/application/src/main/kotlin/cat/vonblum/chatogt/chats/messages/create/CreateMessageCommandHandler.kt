package cat.vonblum.chatogt.chats.messages.create

import cat.vonblum.chatogt.chats.messages.Message
import cat.vonblum.chatogt.chats.messages.MessageContent
import cat.vonblum.chatogt.chats.messages.MessageId
import cat.vonblum.chatogt.chats.messages.ReportingMessages
import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.shared.domain.event.EventBus
import cat.vonblum.chatogt.shared.domain.generator.IdGenerator

class CreateMessageCommandHandler(
    private val eventBus: EventBus,
    private val idGenerator: IdGenerator,
    private val reporting: ReportingMessages
) : CommandHandler {

    fun handle(command: CreateMessageCommand) = Message.create(
        MessageId(idGenerator.next()),
        ChatId(command.chatId),
        UserId(command.authorId),
        MessageContent(command.content)
    ).let { message ->
        reporting.report(message)
        eventBus.publish(message.pullEvents())
    }

}