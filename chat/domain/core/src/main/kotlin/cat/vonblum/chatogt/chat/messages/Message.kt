package cat.vonblum.chatogt.chat.messages

import cat.vonblum.chatogt.chat.shared.ChatId
import cat.vonblum.chatogt.chat.shared.UserId
import cat.vonblum.chatogt.usermanagement.domain.aggregate.AggregateRoot
import cat.vonblum.chatogt.usermanagement.domain.event.Event

class Message(
    val id: MessageId,
    val chatId: ChatId,
    val authorId: UserId,
    private var _content: MessageContent
) : AggregateRoot() {

    companion object {

        fun create(id: MessageId, chatId: ChatId, authorId: UserId, content: MessageContent): Message =
            Message(id, chatId, authorId, content).also { message ->
                message.record(
                    MessageCreatedEvent(
                        message.id.value,
                        message.chatId.value,
                        message.authorId.value,
                        message._content.value
                    )
                )
            }

    }

    override fun apply(event: Event) {
        TODO("Not yet implemented")
    }

    val content get() = _content

    fun update(content: MessageContent) = this.apply { this._content = content }

}