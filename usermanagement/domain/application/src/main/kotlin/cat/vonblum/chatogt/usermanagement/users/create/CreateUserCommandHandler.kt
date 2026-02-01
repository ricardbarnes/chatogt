package cat.vonblum.chatogt.usermanagement.users.create

import cat.vonblum.chatogt.usermanagement.domain.command.CommandHandler
import cat.vonblum.chatogt.usermanagement.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.domain.generator.IdGenerator
import cat.vonblum.chatogt.usermanagement.users.model.User
import cat.vonblum.chatogt.usermanagement.users.model.UserEmail
import cat.vonblum.chatogt.usermanagement.users.model.UserId
import cat.vonblum.chatogt.usermanagement.users.model.UserNotificationType
import cat.vonblum.chatogt.usermanagement.users.model.UserPassword
import cat.vonblum.chatogt.usermanagement.users.model.UserType
import cat.vonblum.chatogt.usermanagement.users.port.ForNotifyingUsers
import cat.vonblum.chatogt.usermanagement.users.port.ForSendingUsers
import cat.vonblum.chatogt.usermanagement.users.port.ForStoringUsers

class CreateUserCommandHandler(
    private val idGenerator: IdGenerator,
    private val storing: ForStoringUsers,
    private val sending: ForSendingUsers,
    private val notifyingMap: Map<UserNotificationType, ForNotifyingUsers>,
    private val eventBus: EventBus
) : CommandHandler {

    @Suppress("unused")
    fun handle(command: CreateUserCommand) = User.create(
        UserId(idGenerator.next()),
        UserEmail(command.email),
        UserPassword(command.password),
        UserType.valueOf(command.type),
        command.notificationTypes.map { UserNotificationType.valueOf(it) }.toSet()
    ).also { user ->
        storing.store(user)
        sending.send(user)
        notifyUser(user) // TODO: create a messaging service and consume the event there + remove notifications from this bounded context
        eventBus.publish(user.pullEvents())
    }

    private fun notifyUser(user: User) {
        user.notificationTypes()
            .mapNotNull(notifyingMap::get)
            .toSet()
            .forEach { it.notify(user) }
    }

}