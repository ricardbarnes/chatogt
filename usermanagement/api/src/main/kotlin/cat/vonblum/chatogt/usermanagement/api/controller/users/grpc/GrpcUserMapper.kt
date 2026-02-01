package cat.vonblum.chatogt.usermanagement.api.controller.users.grpc

import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import cat.vonblum.chatogt.usermanagement.users.delete.DeleteUserByIdCommand
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByIdQuery
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByIdResponse
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByEmailQuery
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByEmailResponse
import user.User
import java.util.*

class GrpcUserMapper {

    fun toDomain(dto: User.CreateUserRequest): CreateUserCommand =
        CreateUserCommand(
            dto.email,
            dto.password,
            dto.type,
            dto.notificationTypesList.toSet()
        )

    fun toDomain(dto: User.FindUserByIdRequest): FindUserByIdQuery {
        return FindUserByIdQuery(UUID.fromString(dto.id))
    }

    fun toInfra(response: FindUserByIdResponse): User.FindUserByIdResponse {
        return User.FindUserByIdResponse.newBuilder()
            .setId(response.id.toString())
            .setEmail(response.email)
            .build()
    }

    fun toDomain(dto: User.FindUserByEmailRequest): FindUserByEmailQuery {
        return FindUserByEmailQuery(dto.email)
    }

    fun toInfra(response: FindUserByEmailResponse): User.FindUserByEmailResponse {
        return User.FindUserByEmailResponse.newBuilder()
            .setId(response.id.toString())
            .setEmail(response.email)
            .build()
    }

    fun toDomain(dto: User.DeleteUserByIdRequest): DeleteUserByIdCommand {
        return DeleteUserByIdCommand(UUID.fromString(dto.id))
    }

}