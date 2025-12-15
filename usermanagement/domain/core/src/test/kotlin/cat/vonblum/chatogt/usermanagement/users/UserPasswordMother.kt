package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.domain.valueobject.StringFaker

object UserPasswordMother {

    fun create(password: String?): UserPassword = UserPassword(password ?: StringFaker.password())

}
