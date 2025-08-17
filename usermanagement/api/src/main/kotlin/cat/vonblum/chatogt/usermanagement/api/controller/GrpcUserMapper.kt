package cat.vonblum.chatogt.usermanagement.api.controller

import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import cat.vonblum.chatogt.usermanagement.users.delete.DeleteUserByIdCommand
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByNameQuery
import org.springframework.stereotype.Component
import user.UserOuterClass.CreateUserRequest
import user.UserOuterClass.DeleteUserByIdRequest
import user.UserOuterClass.FindUserByNameRequest
import user.UserOuterClass.User

@Component
class GrpcUserMapper {

    fun toDomain(request: CreateUserRequest): CreateUserCommand {
        TODO()
    }

    fun toDomain(request: FindUserByNameRequest): FindUserByNameQuery {
        TODO()
    }

    fun toDomain(request: DeleteUserByIdRequest): DeleteUserByIdCommand {
        TODO()
    }

    fun toInfra(dto: FindUserByNameQuery): User {
        TODO()
    }

}