package cat.vonblum.chatogt.chat.messages.delete

import cat.vonblum.chatogt.usermanagement.domain.command.Command
import java.util.UUID

class DeleteMessageCommand(val id: UUID) : Command