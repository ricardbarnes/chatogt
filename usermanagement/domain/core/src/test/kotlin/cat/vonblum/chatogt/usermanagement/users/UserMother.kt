package cat.vonblum.chatogt.usermanagement.users

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
