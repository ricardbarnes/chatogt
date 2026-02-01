package cat.vonblum.chatogt.usermanagement.producer.provider.users.mailchimp

import cat.vonblum.chatogt.usermanagement.users.port.ForNotifyingUsers
import cat.vonblum.chatogt.usermanagement.users.model.User

class MailchimpForNotifyingUsers : ForNotifyingUsers {

    override fun notify(user: User) {
        println("An email to ${user.email().value} has been sent through Mail Chimp")
    }

}