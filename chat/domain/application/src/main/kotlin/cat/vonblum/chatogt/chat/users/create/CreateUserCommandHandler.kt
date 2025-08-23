package cat.vonblum.chatogt.chat.users.create

import cat.vonblum.chatogt.chat.shared.UserId
import cat.vonblum.chatogt.shared.domain.event.EventBus
import cat.vonblum.chatogt.shared.domain.generator.HashGenerator
import cat.vonblum.chatogt.shared.domain.generator.IdGenerator
import cat.vonblum.chatogt.chat.users.User
import cat.vonblum.chatogt.chat.users.UserName
import cat.vonblum.chatogt.chat.users.UserPassword

class CreateUserCommandHandler(
    private val eventBus: EventBus,
    private val idGenerator: IdGenerator,
    private val hashGenerator: HashGenerator
) {

    fun handle(command: CreateUserCommand): User =
        User.create(
            UserId(idGenerator.next()),
            UserName(command.name),
            UserPassword(hashGenerator.hash(command.password))
        ).also { user -> eventBus.publish(user.pullEvents()) }

}