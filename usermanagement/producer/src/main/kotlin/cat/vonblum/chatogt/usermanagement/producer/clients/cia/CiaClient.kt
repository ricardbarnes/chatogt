package cat.vonblum.chatogt.usermanagement.producer.clients.cia

class CiaClient {

    fun doRequest(request: CiaCreateUserRequest) {
        println("User request for ${request.email} was sent to the CIA")
    }

}