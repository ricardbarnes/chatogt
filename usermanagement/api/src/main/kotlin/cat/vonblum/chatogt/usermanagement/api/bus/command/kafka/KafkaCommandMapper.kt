package cat.vonblum.chatogt.usermanagement.api.bus.command.kafka

import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import cat.vonblum.chatogt.usermanagement.users.delete.DeleteUserByIdCommand
import cat.vonblum.chatogt.usermanagement.users.update.UpdateUserPasswordCommand
import user.User

class KafkaCommandMapper {

    fun toInfra(command: CreateUserCommand): ByteArray {
        return User.CreateUserRequest.newBuilder()
            .setEmail(command.email)
            .setPassword(command.password)
            .build()
            .toByteArray()
    }

    fun toInfra(command: DeleteUserByIdCommand): ByteArray {
        return User.DeleteUserByIdRequest.newBuilder()
            .setId(command.id.toString())
            .build()
            .toByteArray()
    }

    fun toInfra(command: UpdateUserPasswordCommand): ByteArray {
        return User.UpdateUserPasswordRequest.newBuilder()
            .setId(command.id.toString())
            .setPassword(command.password)
            .build()
            .toByteArray()
    }

}