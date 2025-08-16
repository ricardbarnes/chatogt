package cat.vonblum.chatogt.usermanagement.api.controller

import com.google.protobuf.Empty
import net.devh.boot.grpc.server.service.GrpcService
import user.UserOuterClass
import user.UserServiceGrpcKt

@GrpcService
class GrpcUserController : UserServiceGrpcKt.UserServiceCoroutineImplBase() {

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