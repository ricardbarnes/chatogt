package cat.vonblum.chatogt.usermanagement.users.delete

import cat.vonblum.chatogt.shared.domain.command.Command
import java.util.UUID

class DeleteUserByIdCommand(val id: UUID) : Command