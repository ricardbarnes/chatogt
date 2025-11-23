package cat.vonblum.chatogt.usermanagement.users.update

import cat.vonblum.chatogt.usermanagement.domain.command.Command
import java.util.UUID

class UpdateUserPasswordCommand(
    val id: UUID,
    val password: String,
) : Command