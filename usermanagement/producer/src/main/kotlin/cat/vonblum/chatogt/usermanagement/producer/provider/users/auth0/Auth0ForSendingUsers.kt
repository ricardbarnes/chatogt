package cat.vonblum.chatogt.usermanagement.producer.provider.users.auth0

import cat.vonblum.chatogt.usermanagement.producer.clients.cia.Auth0Client
import cat.vonblum.chatogt.usermanagement.producer.clients.cia.Auth0CreateUserRequest
import cat.vonblum.chatogt.usermanagement.users.port.ForSendingUsers
import cat.vonblum.chatogt.usermanagement.users.aggregate.User

class Auth0ForSendingUsers(private val client: Auth0Client) : ForSendingUsers {

    override fun send(user: User) {
        client.doRequest(Auth0CreateUserRequest(user.email().value))
    }

}