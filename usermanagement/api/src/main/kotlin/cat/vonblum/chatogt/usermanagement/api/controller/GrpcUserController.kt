package cat.vonblum.chatogt.usermanagement.api.controller

import cat.vonblum.chatogt.shared.domain.command.CommandBus
import cat.vonblum.chatogt.shared.domain.query.QueryBus
import com.google.protobuf.Empty
import net.devh.boot.grpc.server.service.GrpcService
import user.UserOuterClass.CreateUserRequest
import user.UserOuterClass.DeleteUserByIdRequest
import user.UserOuterClass.FindUserByNameRequest
import user.UserOuterClass.User
import user.UserServiceGrpcKt

@GrpcService
class GrpcUserController(
    private val mapper: GrpcUserMapper,
    private val commandBus: CommandBus,
    private val queryBus: QueryBus
) : UserServiceGrpcKt.UserServiceCoroutineImplBase() {

    override suspend fun createUser(request: CreateUserRequest): Empty {
        // TODO
        return super.createUser(request)
    }

    override suspend fun findUserByName(request: FindUserByNameRequest): User {
        // TODO
        return super.findUserByName(request)
    }

    override suspend fun deleteUserById(request: DeleteUserByIdRequest): Empty {
        // TODO
        return super.deleteUserById(request)
    }

}