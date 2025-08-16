package cat.vonblum.chatogt.usermanagement.api.controller

import net.devh.boot.grpc.server.service.GrpcService
import user.UserOuterClass
import user.UserServiceGrpcKt

@GrpcService
class GrpcUserController : UserServiceGrpcKt.UserServiceCoroutineImplBase() {

    override suspend fun createUser(request: UserOuterClass.User): UserOuterClass.User {
        // TODO
        return UserOuterClass.User.newBuilder().build()
    }

}