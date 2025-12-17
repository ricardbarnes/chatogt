package cat.vonblum.chatogt.usermanagement.producer.provider.users.cia

import cat.vonblum.chatogt.usermanagement.producer.clients.cia.CiaClient
import cat.vonblum.chatogt.usermanagement.producer.clients.cia.CiaCreateUserRequest
import cat.vonblum.chatogt.usermanagement.users.ForSendingUsers
import cat.vonblum.chatogt.usermanagement.users.User

class CiaForSendingUsers(private val client: CiaClient) : ForSendingUsers {

    override fun send(user: User) {
        client.doRequest(CiaCreateUserRequest(user.email.value))
    }

}