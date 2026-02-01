package cat.vonblum.chatogt.usermanagement.users.create

import cat.vonblum.chatogt.usermanagement.domain.valueobject.StringFaker
import cat.vonblum.chatogt.usermanagement.users.model.UserNotificationType

object CreateUserCommandMother {

    fun create(
        name: String?,
        password: String?,
        type: String?,
        notificationTypes: Set<String>?
    ): CreateUserCommand {
        val defaultNotifications = setOf(UserNotificationType.EMAIL.name)
        return CreateUserCommand(
            name ?: StringFaker.name(),
            password ?: StringFaker.password(),
            type ?: "POOR",
            notificationTypes?.ifEmpty { defaultNotifications } ?: defaultNotifications
        )
    }


}
