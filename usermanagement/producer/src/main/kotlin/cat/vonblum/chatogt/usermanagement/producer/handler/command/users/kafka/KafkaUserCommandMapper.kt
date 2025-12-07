package cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka

import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import user.User

class KafkaUserCommandMapper {

    fun toDomain(request: User.CreateUserCommand): CreateUserCommand {
        return CreateUserCommand(
            request.email,
            request.password,
        )
    }

}