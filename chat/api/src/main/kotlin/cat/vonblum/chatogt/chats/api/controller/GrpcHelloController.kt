package cat.vonblum.chatogt.chats.api.controller

import hello.Hello
import hello.HelloServiceGrpcKt
import net.devh.boot.grpc.server.service.GrpcService

@GrpcService
class GrpcHelloController : HelloServiceGrpcKt.HelloServiceCoroutineImplBase() { // TODO: remove when the proper controllers are in place.

    override suspend fun sayHello(request: Hello.HelloRequest): Hello.HelloResponse {
        val message = "Hello ${request.name}!"
        return Hello.HelloResponse.newBuilder().setMessage(message).build()
    }

}