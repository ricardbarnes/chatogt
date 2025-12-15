package cat.vonblum.chatogt.usermanagement.producer.provider.users.fbi

import cat.vonblum.chatogt.usermanagement.users.ForSendingUsers
import cat.vonblum.chatogt.usermanagement.users.User

class FbiForSendingUsers : ForSendingUsers {

    override fun send(user: User) {
        println("User ${user.email} sent to the FBI")
    }

}