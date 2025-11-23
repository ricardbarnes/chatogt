package cat.vonblum.chatogt.chat.chats

import cat.vonblum.chatogt.chat.shared.ChatId
import cat.vonblum.chatogt.chat.shared.UserId
import cat.vonblum.chatogt.usermanagement.domain.aggregate.AggregateRoot
import cat.vonblum.chatogt.usermanagement.domain.event.Event

class Chat(
    val id: ChatId,
    val participantIds: Set<UserId>,
    private var _status: ChatStatus = ChatStatus.NORMAL
) : AggregateRoot() {

    companion object {

        fun create(id: ChatId, participantIds: Set<UserId>): Chat =
            Chat(id, participantIds).also { chat ->
                chat.record(
                    ChatCreatedEvent(
                        participantIds.stream().map { it.value }.toList(),
                        id.value
                    )
                )
            }

    }

    override fun applyEvent(event: Event) {
        TODO("Not yet implemented")
    }

    val status: ChatStatus get() = this._status

    fun mute() = { _status = ChatStatus.MUTED }.also { record(ChatMutedEvent(id.value)) }

    fun unmute() = { _status = ChatStatus.NORMAL }.also { record(ChatUnmutedEvent(id.value)) }

    fun delete() = { _status = ChatStatus.DELETED }.also { record(ChatDeletedEvent(id.value)) }

}