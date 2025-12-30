package cat.vonblum.chatogt.usermanagement.users.create

import cat.vonblum.chatogt.usermanagement.domain.command.CommandHandler
import cat.vonblum.chatogt.usermanagement.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.domain.generator.IdGenerator
import cat.vonblum.chatogt.usermanagement.users.*

class CreateUserCommandHandler(
    private val idGenerator: IdGenerator,
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