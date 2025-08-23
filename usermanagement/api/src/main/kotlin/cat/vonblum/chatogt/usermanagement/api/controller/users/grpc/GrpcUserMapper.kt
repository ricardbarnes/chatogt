package cat.vonblum.chatogt.usermanagement.api.controller.users.grpc

import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import cat.vonblum.chatogt.usermanagement.users.delete.DeleteUserByIdCommand
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByIdQuery
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByIdResponse
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByNameQuery
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByNameResponse
import org.springframework.stereotype.Component
import user.UserOuterClass
import java.util.UUID

@Component
class GrpcUserMapper {

    fun toDomain(dto: UserOuterClass.CreateUserRequest): CreateUserCommand {
        return CreateUserCommand(
            dto.name,
            dto.password,
        )
    }

    fun toDomain(dto: UserOuterClass.FindUserByIdRequest): FindUserByIdQuery {
        return FindUserByIdQuery(dto.id)
    }

    fun toDomain(dto: UserOuterClass.FindUserByNameRequest): FindUserByNameQuery {
        return FindUserByNameQuery(dto.name)
    }

    fun toDomain(dto: UserOuterClass.DeleteUserByIdRequest): DeleteUserByIdCommand {
        return DeleteUserByIdCommand(UUID.fromString(dto.id))
    }

    fun toInfra(response: FindUserByIdResponse): UserOuterClass.User {
        return UserOuterClass.User.newBuilder()
            .setId(response.id.toString())
            .setName(response.name)
            .build()
    }

    fun toInfra(response: FindUserByNameResponse): UserOuterClass.User {
        return UserOuterClass.User.newBuilder()
            .setId(response.id.toString())
            .setName(response.name)
            .build()
    }

}