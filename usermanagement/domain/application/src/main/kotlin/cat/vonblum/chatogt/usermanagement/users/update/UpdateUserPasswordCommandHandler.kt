package cat.vonblum.chatogt.usermanagement.users.update

import cat.vonblum.chatogt.usermanagement.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.users.port.ForFindingUsers
import cat.vonblum.chatogt.usermanagement.users.aggregate.UserId
import cat.vonblum.chatogt.usermanagement.users.aggregate.UserPassword

class UpdateUserPasswordCommandHandler(
    private val findingUsers: ForFindingUsers,
    private val eventBus: EventBus
) {

    fun handle(command: UpdateUserPasswordCommand) =
        findingUsers.findById(UserId(command.id))
            .also { it.updatePassword(UserPassword(command.password)) }
            .pullEvents()
            .let(eventBus::publish)
}
