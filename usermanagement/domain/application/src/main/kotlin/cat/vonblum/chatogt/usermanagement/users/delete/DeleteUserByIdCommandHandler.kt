package cat.vonblum.chatogt.usermanagement.users.delete

import cat.vonblum.chatogt.usermanagement.users.DeletingUsers
import cat.vonblum.chatogt.usermanagement.users.UserId

class DeleteUserByIdCommandHandler(private val deleting: DeletingUsers) {

    fun handle(command: DeleteUserByIdCommand) = deleting.deleteById(UserId(command.id))

}