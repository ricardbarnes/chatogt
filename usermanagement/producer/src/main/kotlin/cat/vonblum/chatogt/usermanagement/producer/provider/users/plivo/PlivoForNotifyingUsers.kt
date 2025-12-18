package cat.vonblum.chatogt.usermanagement.producer.provider.users.plivo

import cat.vonblum.chatogt.usermanagement.users.ForNotifyingUsers
import cat.vonblum.chatogt.usermanagement.users.User

class PlivoForNotifyingUsers : ForNotifyingUsers {

    override fun notify(user: User) {
        println("A SMS to ${user.email().value} has been sent through Plivo")
    }

}