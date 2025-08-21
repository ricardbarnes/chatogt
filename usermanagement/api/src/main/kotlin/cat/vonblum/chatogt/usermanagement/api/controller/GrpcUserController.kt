package cat.vonblum.chatogt.usermanagement.api.controller

import cat.vonblum.chatogt.shared.domain.command.CommandBus
import cat.vonblum.chatogt.shared.domain.query.QueryBus
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByIdResponse
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByNameResponse
import com.google.protobuf.Empty
import net.devh.boot.grpc.server.service.GrpcService
import user.UserOuterClass
import user.UserServiceGrpcKt

@GrpcService
class GrpcUserController(
    private val mapper: GrpcUserMapper,
    private val commandBus: CommandBus,
    private val queryBus: QueryBus
) : UserServiceGrpcKt.UserServiceCoroutineImplBase() {

    override suspend fun createUser(request: UserOuterClass.CreateUserRequest): Empty {
        val command = mapper.toDomain(request)
        commandBus.dispatch(command)
        return Empty.getDefaultInstance()
    }

    override suspend fun findUserById(request: UserOuterClass.FindUserByIdRequest): UserOuterClass.User {
        val query = mapper.toDomain(request)
        val response = queryBus.ask(query)
        return mapper.toInfra(response as FindUserByIdResponse)
    }

    override suspend fun findUserByName(request: UserOuterClass.FindUserByNameRequest): UserOuterClass.User {
        val query = mapper.toDomain(request)
        val response = queryBus.ask(query)
        return mapper.toInfra(response as FindUserByNameResponse)
    }

    override suspend fun deleteUserById(request: UserOuterClass.DeleteUserByIdRequest): Empty {
        val command = mapper.toDomain(request)
        commandBus.dispatch(command)
        return Empty.getDefaultInstance()
    }

}