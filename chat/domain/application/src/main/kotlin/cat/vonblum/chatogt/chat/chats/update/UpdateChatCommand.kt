package cat.vonblum.chatogt.chat.chats.update

import cat.vonblum.chatogt.usermanagement.domain.command.Command
import java.util.UUID

class UpdateChatCommand(
    val id: UUID,
    val status: String
) : Command