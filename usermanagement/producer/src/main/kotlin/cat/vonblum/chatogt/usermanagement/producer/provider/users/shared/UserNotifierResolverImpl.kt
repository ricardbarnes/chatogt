package cat.vonblum.chatogt.usermanagement.producer.provider.users.shared

import cat.vonblum.chatogt.usermanagement.users.ForNotifyingUsers
import cat.vonblum.chatogt.usermanagement.users.User
import cat.vonblum.chatogt.usermanagement.users.UserNotificationType
import cat.vonblum.chatogt.usermanagement.users.UserNotifierResolver

class UserNotifierResolverImpl(
    private val emailNotifying: ForNotifyingUsers,
    private val smsNotifying: ForNotifyingUsers
) : UserNotifierResolver {

    override fun resolveFor(user: User): Set<ForNotifyingUsers> {
        return user.notificationTypes
            .map {
                when (it) {
                    UserNotificationType.EMAIL -> emailNotifying
                    UserNotificationType.SMS -> smsNotifying
                }
            }
            .toSet()
    }

}