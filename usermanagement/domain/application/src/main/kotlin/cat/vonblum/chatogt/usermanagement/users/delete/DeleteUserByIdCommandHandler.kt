package cat.vonblum.chatogt.usermanagement.users.delete

import cat.vonblum.chatogt.usermanagement.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.users.port.ForFindingUsers
import cat.vonblum.chatogt.usermanagement.users.aggregate.UserId

class DeleteUserByIdCommandHandler(
    private val finding: ForFindingUsers,
    private val eventBus: EventBus
) {

    fun handle(command: DeleteUserByIdCommand) =
        finding.findById(UserId(command.id))
            .also { user -> user.delete() }
            .let { eventBus.publish(it.pullEvents()) }

}