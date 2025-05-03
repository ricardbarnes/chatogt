package cat.vonblum.chatogt.chats.users.create

import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.shared.domain.event.EventBus
import cat.vonblum.chatogt.shared.domain.generator.HashGenerator
import cat.vonblum.chatogt.shared.domain.generator.IdGenerator
import cat.vonblum.chatogt.chats.users.User
import cat.vonblum.chatogt.chats.users.UserName
import cat.vonblum.chatogt.chats.users.UserPassword

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