package cat.vonblum.chatogt.usermanagement.users.create

import cat.vonblum.chatogt.shared.domain.command.Command

class CreateUserCommand(
    val name: String,
    val password: String
) : Command