package cat.vonblum.chatogt.chat.users.update

import cat.vonblum.chatogt.shared.domain.command.Command
import java.util.UUID

class UpdateUserCommand(
    val chatIds: List<UUID>,
    val blockedIds: List<UUID>,
) : Command