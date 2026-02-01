package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.domain.valueobject.StringFaker
import cat.vonblum.chatogt.usermanagement.users.model.UserEmail

object UserEmailMother {

    fun create(email: String?): UserEmail = UserEmail(email ?: StringFaker.name())

}