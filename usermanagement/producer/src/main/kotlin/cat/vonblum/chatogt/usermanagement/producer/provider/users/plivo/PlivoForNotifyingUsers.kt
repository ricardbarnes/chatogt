package cat.vonblum.chatogt.usermanagement.producer.provider.users.plivo

import cat.vonblum.chatogt.usermanagement.users.port.ForNotifyingUsers
import cat.vonblum.chatogt.usermanagement.users.aggregate.User

class PlivoForNotifyingUsers : ForNotifyingUsers {

    override fun notify(user: User) {
        println("A SMS to ${user.email().value} has been sent through Plivo")
    }

}