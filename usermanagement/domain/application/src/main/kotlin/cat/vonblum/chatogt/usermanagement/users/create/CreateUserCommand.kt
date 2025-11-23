package cat.vonblum.chatogt.usermanagement.users.create

import cat.vonblum.chatogt.usermanagement.domain.command.Command

class CreateUserCommand(
    val name: String,
    val password: String
) : Command