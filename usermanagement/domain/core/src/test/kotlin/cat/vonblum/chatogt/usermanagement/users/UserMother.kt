package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.users.aggregate.User
import cat.vonblum.chatogt.usermanagement.users.aggregate.UserEmail
import cat.vonblum.chatogt.usermanagement.users.aggregate.UserId
import cat.vonblum.chatogt.usermanagement.users.aggregate.UserNotificationType
import cat.vonblum.chatogt.usermanagement.users.aggregate.UserPassword
import cat.vonblum.chatogt.usermanagement.users.aggregate.UserType
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
