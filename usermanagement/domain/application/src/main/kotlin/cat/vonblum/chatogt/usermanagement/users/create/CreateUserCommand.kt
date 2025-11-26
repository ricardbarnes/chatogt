package cat.vonblum.chatogt.usermanagement.users.create

import cat.vonblum.chatogt.usermanagement.domain.command.Command

class CreateUserCommand(
    val email: String,
    val password: String
) : Command