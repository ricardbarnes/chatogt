package cat.vonblum.chatogt.usermanagement.users.aggregate

import cat.vonblum.chatogt.usermanagement.domain.aggregate.AggregateRoot
import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.users.event.UserCreatedEvent
import cat.vonblum.chatogt.usermanagement.users.event.UserDeletedEvent
import cat.vonblum.chatogt.usermanagement.users.event.UserPasswordUpdatedEvent

class User private constructor() : AggregateRoot() {

    private lateinit var id: UserId

    private lateinit var email: UserEmail

    private lateinit var password: UserPassword

    private lateinit var status: UserStatus

    private lateinit var type: UserType

    private lateinit var notificationTypes: Set<UserNotificationType>

    override fun apply(event: Event) {
        when (event) {
            is UserCreatedEvent -> on(event)
            is UserPasswordUpdatedEvent -> on(event)
            is UserDeletedEvent -> on(event)
        }
    }

    private fun on(event: UserCreatedEvent) {
        id = UserId(event.aggregateId)
        email = UserEmail(event.email)
        password = UserPassword(event.password)
        status = UserStatus.ACTIVE
        type = UserType.valueOf(event.type)
        notificationTypes =
            event.notificationTypes.map { UserNotificationType.valueOf(it) }.toSet()
    }

    private fun on(event: UserPasswordUpdatedEvent) {
        this.password = UserPassword(event.password)
    }

    private fun on(event: UserDeletedEvent) {
        this.status = UserStatus.DELETED
    }

    fun updatePassword(newPassword: UserPassword) {
        record(
            UserPasswordUpdatedEvent(
                id.value,
                version,
                newPassword.value
            )
        )
    }

    fun delete() {
        record(
            UserDeletedEvent(
                id.value,
                version
            )
        )
    }

    fun id(): UserId = id

    fun email(): UserEmail = email

    fun password(): UserPassword = password

    fun notificationTypes(): Set<UserNotificationType> = notificationTypes

    fun isActive(): Boolean = status == UserStatus.ACTIVE

    fun isDeleted(): Boolean = status == UserStatus.DELETED

    fun isStandard(): Boolean = UserType.STANDARD == type

    fun isPremium(): Boolean = UserType.PREMIUM == type

    fun hasEmailNotifications(): Boolean =
        notificationTypes.any { type -> type.name == UserNotificationType.EMAIL.name }

    fun hasSmsNotifications(): Boolean =
        notificationTypes.any { type -> type.name == UserNotificationType.SMS.name }

    companion object {

        fun create(
            id: UserId,
            email: UserEmail,
            password: UserPassword,
            type: UserType,
            notificationTypes: Set<UserNotificationType>
        ): User {
            val user = User()
            user.record(
                UserCreatedEvent(
                    id.value,
                    user.version,
                    email.value,
                    password.value,
                    type.name,
                    notificationTypes.map { it.name }.toSet(),
                )
            )
            return user
        }

    }

}
