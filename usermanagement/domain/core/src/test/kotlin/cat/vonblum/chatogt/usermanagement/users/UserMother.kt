package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.users.model.User
import cat.vonblum.chatogt.usermanagement.users.model.UserEmail
import cat.vonblum.chatogt.usermanagement.users.model.UserId
import cat.vonblum.chatogt.usermanagement.users.model.UserNotificationType
import cat.vonblum.chatogt.usermanagement.users.model.UserPassword
import cat.vonblum.chatogt.usermanagement.users.model.UserType
import java.util.*

object UserMother {

    fun create(
        id: UserId? = UserId(UUID.randomUUID()),
        name: UserEmail? = UserEmail("pepe@pepe.com"),
        password: UserPassword? = UserPassword("pepe"),
        type: UserType? = UserTypeMother.standard(),
        notificationType: UserNotificationType? = UserNotificationType.EMAIL,
    ): User {
        TODO()
    }

}
