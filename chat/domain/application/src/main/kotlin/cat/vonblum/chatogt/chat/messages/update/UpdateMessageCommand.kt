package cat.vonblum.chatogt.chat.messages.update

import cat.vonblum.chatogt.shared.domain.command.Command
import java.util.UUID

class UpdateMessageCommand(
    val id: UUID,
    val content: String
) : Command