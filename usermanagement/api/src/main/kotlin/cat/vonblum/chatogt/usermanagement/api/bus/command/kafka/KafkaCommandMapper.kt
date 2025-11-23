package cat.vonblum.chatogt.usermanagement.api.bus.command.kafka

import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import cat.vonblum.chatogt.usermanagement.users.delete.DeleteUserByIdCommand
import cat.vonblum.chatogt.usermanagement.users.update.UpdateUserNameCommand
import cat.vonblum.chatogt.usermanagement.users.update.UpdateUserPasswordCommand

class KafkaCommandMapper {

    fun toInfra(command: CreateUserCommand): ByteArray {
        TODO()
    }

    fun toInfra(command: DeleteUserByIdCommand): ByteArray {
        TODO()
    }

    fun toInfra(command: UpdateUserNameCommand): ByteArray {
        TODO()
    }

    fun toInfra(command: UpdateUserPasswordCommand): ByteArray {
        TODO()
    }

}