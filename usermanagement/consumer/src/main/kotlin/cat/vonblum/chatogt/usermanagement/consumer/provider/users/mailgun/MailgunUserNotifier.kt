package cat.vonblum.chatogt.usermanagement.consumer.provider.users.mailgun

import cat.vonblum.chatogt.usermanagement.users.UserCreatedEvent
import cat.vonblum.chatogt.usermanagement.users.UserNotifier

class MailgunUserNotifier : UserNotifier {

    override fun notifyCreation(event: UserCreatedEvent) {
        TODO("Not yet implemented")
    }

}