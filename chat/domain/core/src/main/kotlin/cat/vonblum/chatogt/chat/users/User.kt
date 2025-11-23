package cat.vonblum.chatogt.chat.users

import cat.vonblum.chatogt.chat.shared.UserId
import cat.vonblum.chatogt.usermanagement.domain.aggregate.AggregateRoot
import cat.vonblum.chatogt.usermanagement.domain.event.Event

class User(
    val id: UserId,
    val name: UserName,
    val password: UserPassword,
    val contactIds: MutableSet<UserId>,
) : AggregateRoot() {

    companion object {

        fun create(
            id: UserId,
            name: UserName,
            password: UserPassword,
        ): User = User(id, name, password, mutableSetOf()).also { user ->
            user.record(UserCreatedEvent(id.value, name.value, password.value))
        }

    }

    override fun applyEvent(event: Event) {
        TODO("Not yet implemented")
    }

    fun addContact(userId: UserId) = contactIds.add(userId)

    fun removeContact(userId: UserId) = contactIds.remove(userId)

}