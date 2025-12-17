package cat.vonblum.chatogt.usermanagement.producer.clients.fbi

class FbiClient {

    fun doRequest(request: FbiCreateUserRequest) {
        println("User request for ${request.email} was sent to the CIA")
    }

}