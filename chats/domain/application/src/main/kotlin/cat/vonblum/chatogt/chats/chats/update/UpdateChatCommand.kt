package cat.vonblum.chatogt.chats.chats.update

import cat.vonblum.chatogt.shared.domain.command.Command
import java.util.UUID

class UpdateChatCommand(
    val id: UUID,
    val status: String
) : Command