package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.shared.domain.aggregate.AggregateRoot
import cat.vonblum.chatogt.shared.domain.event.Event
import cat.vonblum.chatogt.usermanagement.shared.roles.Role

class User : AggregateRoot() {

    lateinit var id: UserId
        private set

    lateinit var name: UserName
        private set

    lateinit var password: UserPassword
        private set

    lateinit var role: Role
        private set

    lateinit var status: UserStatus
        private set

    companion object {
        fun create(
            id: UserId,
            name: UserName,
            password: UserPassword,
            role: Role,
            status: UserStatus = UserStatus.ACTIVE,
        ): User {
            val user = User()
            user.applyEvent(
                UserCreatedEvent(
                    aggregateId = id.value,
                    name = name.value,
                    password = password.value,
                    role = role.name,
                    status = status.name,
                )
            )
            return user
        }
    }

    private fun applyUserCreated(event: UserCreatedEvent) {
        this.id = UserId(event.aggregateId)
        this.name = UserName(event.name)
        this.password = UserPassword(event.password)
        this.role = Role.valueOf(event.role)
    }

    private fun applyUserPasswordUpdated(event: UserPasswordUpdatedEvent) {
        this.password = UserPassword(event.password)
    }

    private fun applyUserDeleted(event: UserDeletedEvent) {
        this.status = UserStatus.DELETED
    }

    fun applyEvents(events: List<Event>) {
        events.forEach { event -> applyEvent(event) }
    }

    fun applyEvent(event: Event) {
        when (event) {
            is UserCreatedEvent -> applyUserCreated(event)
            is UserPasswordUpdatedEvent -> applyUserPasswordUpdated(event)
            is UserDeletedEvent -> applyUserDeleted(event)
        }

        record(event)
    }

    fun updateName(newName: UserName) {
        applyEvent(UserNameUpdatedEvent(id.value, newName.value))
    }

    fun updatePassword(newPassword: UserPassword) {
        applyEvent(UserPasswordUpdatedEvent(id.value, newPassword.value))
    }

    fun delete() {
        applyEvent(UserDeletedEvent(id.value))
    }

}
