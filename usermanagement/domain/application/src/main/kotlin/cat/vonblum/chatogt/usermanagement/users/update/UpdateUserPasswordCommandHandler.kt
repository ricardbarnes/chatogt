package cat.vonblum.chatogt.usermanagement.users.update

import cat.vonblum.chatogt.usermanagement.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.users.ForFindingUsers
import cat.vonblum.chatogt.usermanagement.users.UserId
import cat.vonblum.chatogt.usermanagement.users.UserPassword

class UpdateUserPasswordCommandHandler(
    private val forFindingUsers: ForFindingUsers,
    private val eventBus: EventBus
) {

    fun handle(command: UpdateUserPasswordCommand) =
        forFindingUsers.findById(UserId(command.id))
            .also { it.updatePassword(UserPassword(command.password)) }
            .pullEvents()
            .let(eventBus::publish)
}
