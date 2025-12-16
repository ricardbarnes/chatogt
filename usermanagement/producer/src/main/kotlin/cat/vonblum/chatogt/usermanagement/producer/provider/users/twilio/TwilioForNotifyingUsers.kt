package cat.vonblum.chatogt.usermanagement.producer.provider.users.twilio

import cat.vonblum.chatogt.usermanagement.users.ForNotifyingUsers
import cat.vonblum.chatogt.usermanagement.users.User

class TwilioForNotifyingUsers : ForNotifyingUsers {

    override fun notify(user: User) {
        println("A SMS to ${user.email.value} has been sent through Twilio")
    }

}