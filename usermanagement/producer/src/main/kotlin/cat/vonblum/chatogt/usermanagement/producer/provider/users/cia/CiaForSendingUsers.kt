package cat.vonblum.chatogt.usermanagement.producer.provider.users.cia

import cat.vonblum.chatogt.usermanagement.users.ForSendingUsers
import cat.vonblum.chatogt.usermanagement.users.User

class CiaForSendingUsers : ForSendingUsers {

    override fun send(user: User) {
        println("User ${user.email.value} sent to the CIA")
    }

}