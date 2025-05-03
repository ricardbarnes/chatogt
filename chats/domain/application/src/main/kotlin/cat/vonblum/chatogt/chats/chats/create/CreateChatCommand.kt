package cat.vonblum.chatogt.chats.chats.create

import cat.vonblum.chatogt.shared.domain.command.Command
import java.util.*

class CreateChatCommand(val participantIds: List<UUID>) : Command