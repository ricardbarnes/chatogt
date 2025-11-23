package cat.vonblum.chatogt.usermanagement.users.update

import cat.vonblum.chatogt.usermanagement.domain.command.Command
import java.util.UUID

class UpdateUserNameCommand(
    val id: UUID,
    val name: String,
) : Command