package cat.vonblum.chatogt.usermanagement.api.controller.users.grpc

import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import cat.vonblum.chatogt.usermanagement.users.delete.DeleteUserByIdCommand
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByIdQuery
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByIdResponse
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByNameQuery
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByNameResponse
import user.User
import java.util.*

class GrpcUserMapper {

    fun toDomain(dto: User.CreateUserRequest): CreateUserCommand {
        return CreateUserCommand(
            dto.name,
            dto.password
        )
    }

    fun toDomain(dto: User.FindUserByIdRequest): FindUserByIdQuery {
        return FindUserByIdQuery(UUID.fromString(dto.id))
    }

    fun toInfra(response: FindUserByIdResponse): User.FindUserByIdResponse {
        return User.FindUserByIdResponse.newBuilder()
            .setId(response.id.toString())
            .setName(response.name)
            .build()
    }

    fun toDomain(dto: User.FindUserByNameRequest): FindUserByNameQuery {
        return FindUserByNameQuery(dto.name)
    }

    fun toInfra(response: FindUserByNameResponse): User.FindUserByNameResponse {
        return User.FindUserByNameResponse.newBuilder()
            .setId(response.id.toString())
            .setName(response.name)
            .build()
    }

    fun toDomain(dto: User.DeleteUserByIdRequest): DeleteUserByIdCommand {
        return DeleteUserByIdCommand(UUID.fromString(dto.id))
    }

}