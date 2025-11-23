package cat.vonblum.chatogt.chat.messages.create

import cat.vonblum.chatogt.chat.messages.Message
import cat.vonblum.chatogt.chat.messages.MessageContent
import cat.vonblum.chatogt.chat.messages.MessageId
import cat.vonblum.chatogt.chat.messages.ReportingMessages
import cat.vonblum.chatogt.chat.shared.ChatId
import cat.vonblum.chatogt.chat.shared.UserId
import cat.vonblum.chatogt.usermanagement.domain.command.CommandHandler
import cat.vonblum.chatogt.usermanagement.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.domain.generator.IdGenerator

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