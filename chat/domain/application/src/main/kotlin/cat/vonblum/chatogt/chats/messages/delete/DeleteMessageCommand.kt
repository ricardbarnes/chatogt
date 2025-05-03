package cat.vonblum.chatogt.chats.messages.delete

import cat.vonblum.chatogt.shared.domain.command.Command
import java.util.UUID

class DeleteMessageCommand(val id: UUID) : Command