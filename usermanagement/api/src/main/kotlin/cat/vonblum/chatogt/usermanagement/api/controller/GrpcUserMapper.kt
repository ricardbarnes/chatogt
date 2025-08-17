package cat.vonblum.chatogt.usermanagement.api.controller

import cat.vonblum.chatogt.shared.domain.command.Command
import cat.vonblum.chatogt.shared.domain.query.Query
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import cat.vonblum.chatogt.usermanagement.users.delete.DeleteUserByIdCommand
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByNameQuery
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByNameResponse
import org.springframework.stereotype.Component
import user.UserOuterClass.CreateUserRequest
import user.UserOuterClass.DeleteUserByIdRequest
import user.UserOuterClass.FindUserByNameRequest
import user.UserOuterClass.User
import java.util.UUID

@Component
class GrpcUserMapper {

    fun toDomain(request: CreateUserRequest): Command {
        return CreateUserCommand(
            request.name,
            request.password
        )
    }

    fun toDomain(request: FindUserByNameRequest): Query {
        return FindUserByNameQuery(request.name)
    }

    fun toDomain(request: DeleteUserByIdRequest): Command {
        return DeleteUserByIdCommand(UUID.fromString(request.id))
    }

    fun toInfra(dto: FindUserByNameResponse): User {
        return User.newBuilder()
            .setId(dto.id.toString())
            .setName(dto.name)
            .build()
    }

}