package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.domain.aggregate.AggregateRoot
import cat.vonblum.chatogt.usermanagement.domain.event.Event
import java.util.stream.Collectors

class User private constructor() : AggregateRoot() {

    lateinit var id: UserId
        private set

    lateinit var email: UserEmail
        private set

    lateinit var password: UserPassword
        private set

    lateinit var status: UserStatus
        private set

    lateinit var type: UserType
        private set

    lateinit var notificationTypes: Set<UserNotificationType>
        private set

    companion object {

        fun create(
            id: UserId,
            email: UserEmail,
            password: UserPassword,
            type: UserType,
            notificationTypes: Set<UserNotificationType>
        ): User {
            val event = UserCreatedEvent(
                id.value,
                email.value,
                password.value,
                type.name,
                notificationTypes.map { it.name }.toSet(),
            )
            val user = User()
            user.apply(event)
            user.record(event)
            return user
        }

    }

    override fun apply(event: Event) {
        when (event) {
            is UserCreatedEvent -> applyUserCreated(event)
            is UserPasswordUpdatedEvent -> applyUserPasswordUpdated(event)
            is UserDeletedEvent -> applyUserDeleted()
        }
    }

    private fun applyUserCreated(event: UserCreatedEvent) {
        id = UserId(event.aggregateId)
        email = UserEmail(event.email)
        password = UserPassword(event.password)
        status = UserStatus.ACTIVE
        type = UserType.valueOf(event.type)
        notificationTypes =
            event.notificationTypes.stream().map { UserNotificationType.valueOf(it) }.collect(Collectors.toSet())
    }

    private fun applyUserPasswordUpdated(event: UserPasswordUpdatedEvent) {
        this.password = UserPassword(event.password)
    }

    private fun applyUserDeleted() {
        this.status = UserStatus.DELETED
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

    fun isStandard(): Boolean {
        return UserType.STANDARD == type
    }

    fun isPremium(): Boolean {
        return UserType.PREMIUM == type
    }

}
