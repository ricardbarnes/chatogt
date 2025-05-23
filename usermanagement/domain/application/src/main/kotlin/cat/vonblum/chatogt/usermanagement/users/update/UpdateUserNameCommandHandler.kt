package cat.vonblum.chatogt.usermanagement.users.update

import cat.vonblum.chatogt.shared.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.users.FindingUsers
import cat.vonblum.chatogt.usermanagement.users.UserId
import cat.vonblum.chatogt.usermanagement.users.UserName

class UpdateUserNameCommandHandler(
    private val findingUsers: FindingUsers,
    private val eventBus: EventBus
) {

    fun handle(command: UpdateUserNameCommand) =
        findingUsers.findById(UserId(command.id))
            .also { it.updateName(UserName(command.name)) }
            .pullEvents()
            .let(eventBus::publish)
}
