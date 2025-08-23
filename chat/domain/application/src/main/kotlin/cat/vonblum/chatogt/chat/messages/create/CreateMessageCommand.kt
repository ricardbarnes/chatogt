package cat.vonblum.chatogt.chat.messages.create

import cat.vonblum.chatogt.shared.domain.command.Command
import java.util.UUID

class CreateMessageCommand(
    val chatId: UUID,
    val authorId: UUID,
    val content: String
) : Command