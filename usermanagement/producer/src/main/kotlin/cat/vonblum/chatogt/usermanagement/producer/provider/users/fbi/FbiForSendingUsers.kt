package cat.vonblum.chatogt.usermanagement.producer.provider.users.fbi

import cat.vonblum.chatogt.usermanagement.producer.clients.fbi.FbiClient
import cat.vonblum.chatogt.usermanagement.producer.clients.fbi.FbiCreateUserRequest
import cat.vonblum.chatogt.usermanagement.users.ForSendingUsers
import cat.vonblum.chatogt.usermanagement.users.User

class FbiForSendingUsers(private val client: FbiClient) : ForSendingUsers {

    override fun send(user: User) {
        client.doRequest(FbiCreateUserRequest(user.email.value))
    }

}