package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.users.aggregate.UserNotificationType

object UserNotificationTypeMother {

    fun email() = UserNotificationType.EMAIL

    fun sms() = UserNotificationType.SMS

}