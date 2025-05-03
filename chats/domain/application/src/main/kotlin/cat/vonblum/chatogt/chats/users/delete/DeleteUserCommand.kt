package cat.vonblum.chatogt.chats.users.delete

import cat.vonblum.chatogt.shared.domain.command.Command
import java.util.UUID

class DeleteUserCommand(val id: UUID) : Command