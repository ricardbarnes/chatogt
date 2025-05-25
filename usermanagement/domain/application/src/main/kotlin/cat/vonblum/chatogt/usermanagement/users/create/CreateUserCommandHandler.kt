package cat.vonblum.chatogt.usermanagement.users.create

import cat.vonblum.chatogt.shared.domain.event.EventBus
import cat.vonblum.chatogt.shared.domain.generator.IdGenerator
import cat.vonblum.chatogt.usermanagement.users.*

class CreateUserCommandHandler(
    private val idGenerator: IdGenerator,
    private val eventBus: EventBus
) {

    fun handle(command: CreateUserCommand) = User.create(
        UserId(idGenerator.next()),
        UserName(command.name),
        UserPassword(command.password),
    ).also { user -> eventBus.publish(user.pullEvents()) }

}