package cat.vonblum.chatogt.usermanagement.users.delete

import cat.vonblum.chatogt.usermanagement.domain.command.Command
import java.util.UUID

data class DeleteUserByIdCommand(val id: UUID) : Command