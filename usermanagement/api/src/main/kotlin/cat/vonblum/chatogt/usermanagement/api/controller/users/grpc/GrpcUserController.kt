package cat.vonblum.chatogt.usermanagement.api.controller.users.grpc

import cat.vonblum.chatogt.shared.domain.command.CommandBus
import cat.vonblum.chatogt.shared.domain.query.QueryBus
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByIdResponse
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByNameResponse
import com.google.protobuf.Empty
import net.devh.boot.grpc.server.service.GrpcService
import user.User
import user.UserServiceGrpcKt

@GrpcService
class GrpcUserController(
    private val mapper: GrpcUserMapper,
    private val commandBus: CommandBus,
    private val queryBus: QueryBus
) : UserServiceGrpcKt.UserServiceCoroutineImplBase() {

    override suspend fun createUser(request: User.CreateUserRequest): Empty {
        val command = mapper.toDomain(request)
        commandBus.dispatch(command)
        return Empty.getDefaultInstance()
    }

    override suspend fun findUserById(request: User.FindUserByIdRequest): User.FindUserByIdResponse {
        val query = mapper.toDomain(request)
        val response = queryBus.ask(query) as FindUserByIdResponse
        return mapper.toInfra(response)
    }

    override suspend fun findUserByName(request: User.FindUserByNameRequest): User.FindUserByNameResponse {
        val query = mapper.toDomain(request)
        val response = queryBus.ask(query) as FindUserByNameResponse
        return mapper.toInfra(response)
    }

    override suspend fun deleteUserById(request: User.DeleteUserByIdRequest): Empty {
        val command = mapper.toDomain(request)
        commandBus.dispatch(command)
        return Empty.getDefaultInstance()
    }

}