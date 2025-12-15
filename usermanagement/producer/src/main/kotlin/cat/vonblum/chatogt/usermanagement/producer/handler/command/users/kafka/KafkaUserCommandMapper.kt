package cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka

import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import user.User

class KafkaUserCommandMapper {

    fun toDomain(dto: User.CreateUserCommand): CreateUserCommand {
        return CreateUserCommand(
            dto.email,
            dto.password,
            dto.type,
        )
    }

}