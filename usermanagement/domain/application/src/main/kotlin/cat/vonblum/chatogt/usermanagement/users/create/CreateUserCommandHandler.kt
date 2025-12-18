package cat.vonblum.chatogt.usermanagement.users.create

import cat.vonblum.chatogt.usermanagement.domain.command.CommandHandler
import cat.vonblum.chatogt.usermanagement.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.domain.generator.IdGenerator
import cat.vonblum.chatogt.usermanagement.users.*

class CreateUserCommandHandler(
    private val idGenerator: IdGenerator,
    private val sending: ForSendingUsers,
    private val notifiersResolver: UserNotificationStrategyResolver,
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
        notifiersResolver.resolveAllFor(user).stream().forEach { it.notify(user) }
        eventBus.publish(user.pullEvents())
    }

}