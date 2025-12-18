package cat.vonblum.chatogt.usermanagement.users

class UserNotificationStrategyResolver(
    private val notifiers: Map<UserNotificationType, ForNotifyingUsers>
) {

    fun resolveAllFor(user: User): Set<ForNotifyingUsers> =
        user.notificationTypes()
            .mapNotNull(notifiers::get)
            .toSet()

}