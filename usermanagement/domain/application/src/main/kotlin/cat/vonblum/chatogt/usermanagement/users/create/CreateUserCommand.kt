package cat.vonblum.chatogt.usermanagement.users.create

import cat.vonblum.chatogt.usermanagement.domain.command.Command

data class CreateUserCommand(
    val email: String,
    val password: String,
    val type: String,
) : Command