package cat.vonblum.chatogt.usermanagement.users.update

import cat.vonblum.chatogt.shared.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.users.ForFindingUsers
import cat.vonblum.chatogt.usermanagement.users.UserId
import cat.vonblum.chatogt.usermanagement.users.UserName

class UpdateUserNameCommandHandler(
    private val forFindingUsers: ForFindingUsers,
    private val eventBus: EventBus
) {

    fun handle(command: UpdateUserNameCommand) =
        forFindingUsers.findById(UserId(command.id))
            .also { it.updateName(UserName(command.name)) }
            .pullEvents()
            .let(eventBus::publish)
}
