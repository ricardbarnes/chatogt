package cat.vonblum.chatogt.users.users.delete

import cat.vonblum.chatogt.users.users.DeletingUsers
import cat.vonblum.chatogt.users.users.UserId

class DeleteUserByIdCommandHandler(private val deleting: DeletingUsers) {

    fun handle(command: DeleteUserByIdCommand) = deleting.deleteById(UserId(command.id))

}