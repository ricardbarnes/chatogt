package cat.vonblum.chatogt.usermanagement.api.bus.command.kafka

import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import user.User

class KafkaCommandMapper {

    fun toInfra(command: CreateUserCommand): ByteArray {
        return User.CreateUserCommand.newBuilder()
            .setEmail(command.email)
            .setPassword(command.password)
            .setType(command.type)
            .addAllNotificationTypes(command.notificationTypes)
            .build()
            .toByteArray()
    }

}