package cat.vonblum.chatogt.chats.users

import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.shared.domain.aggregate.AggregateRoot

class User(
    val id: UserId,
    val name: UserName,
    val password: UserPassword,
    val contactIds: MutableSet<UserId>,
) : cat.vonblum.chatogt.shared.domain.aggregate.AggregateRoot() {

    companion object {

        fun create(
            id: UserId,
            name: UserName,
            password: UserPassword,
        ): User = User(id, name, password, mutableSetOf()).also { user ->
            user.record(UserCreatedEvent(id.value, name.value, password.value))
        }

    }

    fun addContact(userId: UserId) = contactIds.add(userId)

    fun removeContact(userId: UserId) = contactIds.remove(userId)

}