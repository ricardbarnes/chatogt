package cat.vonblum.chatogt.chats.users.create

import cat.vonblum.chatogt.shared.domain.command.Command

class CreateUserCommand(
    val name: String,
    val password: String
) : Command