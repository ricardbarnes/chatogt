package cat.vonblum.chatogt.usermanagement.api.controller

import cat.vonblum.chatogt.shared.domain.command.CommandBus
import cat.vonblum.chatogt.shared.domain.query.QueryBus
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
        // TODO
        return super.createUser(request)
    }

    override suspend fun findUserById(request: UserOuterClass.FindUserByIdRequest): UserOuterClass.User {
        // TODO
        return super.findUserById(request)
    }

    override suspend fun findUserByName(request: UserOuterClass.FindUserByNameRequest): UserOuterClass.User {
        // TODO
        return super.findUserByName(request)
    }

    override suspend fun deleteUserById(request: UserOuterClass.DeleteUserByIdRequest): Empty {
        // TODO
        return super.deleteUserById(request)
    }

}