package cat.vonblum.chatogt.usermanagement.users.create

import cat.vonblum.chatogt.shared.domain.generator.IdGenerator
import cat.vonblum.chatogt.usermanagement.shared.roles.Role
import cat.vonblum.chatogt.usermanagement.users.*

class CreateUserCommandHandler(
    private val storing: StoringUsers,
    private val idGenerator: IdGenerator
) {

    fun handle(command: CreateUserCommand) = User.create(
        UserId(idGenerator.next()),
        UserName(command.name),
        UserPassword(command.password),
        Role.valueOf(command.role)
    ).also { user -> storing.save(user) }

}