package cat.vonblum.chatogt.usermanagement.users.update

import cat.vonblum.chatogt.shared.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.users.FindingUsers
import cat.vonblum.chatogt.usermanagement.users.UserId
import cat.vonblum.chatogt.usermanagement.users.UserPassword

class UpdateUserPasswordCommandHandler(
    private val findingUsers: FindingUsers,
    private val eventBus: EventBus
) {

    fun handle(command: UpdateUserPasswordCommand) =
        findingUsers.findById(UserId(command.id))
            .also { it.updatePassword(UserPassword(command.password)) }
            .pullEvents()
            .let(eventBus::publish)
}
