package cat.vonblum.chatogt.usermanagement.users.delete

import cat.vonblum.chatogt.shared.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.users.FindingUsers
import cat.vonblum.chatogt.usermanagement.users.UserId

class DeleteUserByIdCommandHandler(
    private val finding: FindingUsers,
    private val eventBus: EventBus
) {

    fun handle(command: DeleteUserByIdCommand) = finding.findById(UserId(command.id))
        .also { user -> user.delete() }
        .let { eventBus.publish(it.pullEvents()) }

}