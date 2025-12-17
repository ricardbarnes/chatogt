package cat.vonblum.chatogt.usermanagement.producer.clients.cia

class Auth0Client {

    fun doRequest(request: Auth0CreateUserRequest) {
        println("User request for ${request.email} was sent to Auth0")
    }

}