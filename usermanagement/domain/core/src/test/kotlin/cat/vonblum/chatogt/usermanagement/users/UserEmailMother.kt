package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.domain.valueobject.StringFaker

object UserEmailMother {

    fun create(email: String?): UserEmail = UserEmail(email ?: StringFaker.name())

    fun random(): UserEmail = create(null)

}