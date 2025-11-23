package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.domain.aggregate.AggregateRoot
import cat.vonblum.chatogt.usermanagement.domain.event.Event

class User private constructor() : AggregateRoot() {

    lateinit var id: UserId
        private set

    lateinit var name: UserName
        private set

    lateinit var password: UserPassword
        private set

    lateinit var status: UserStatus
        private set

    companion object {

        fun create(
            id: UserId,
            name: UserName,
            password: UserPassword
        ): User {
            val user = User()
            user.applyEvent(
                UserCreatedEvent(
                    id.value,
                    name.value,
                    password.value
                )
            )
            return user
        }

    }

    override fun applyEvent(event: Event) {
        when (event) {
            is UserCreatedEvent -> applyUserCreated(event)
            is UserPasswordUpdatedEvent -> applyUserPasswordUpdated(event)
            is UserDeletedEvent -> applyUserDeleted()
        }
    }

    private fun applyUserCreated(event: UserCreatedEvent) {
        id = UserId(event.aggregateId)
        name = UserName(event.name)
        password = UserPassword(event.password)
        status = UserStatus.ACTIVE
    }

    private fun applyUserPasswordUpdated(event: UserPasswordUpdatedEvent) {
        this.password = UserPassword(event.password)
    }

    private fun applyUserDeleted() {
        this.status = UserStatus.DELETED
    }

    fun updateName(newName: UserName) {
        name = newName
        record(
            UserNameUpdatedEvent(
                id.value,
                newName.value
            )
        )
    }

    fun updatePassword(newPassword: UserPassword) {
        password = newPassword
        record(
            UserPasswordUpdatedEvent(
                id.value,
                newPassword.value
            )
        )
    }

    fun delete() {
        status = UserStatus.DELETED
        record(
            UserDeletedEvent(
                id.value
            )
        )
    }

}
