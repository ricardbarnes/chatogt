package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.shared.domain.valueobject.StringFaker

object UserPasswordMother {

    fun create(password: String?): UserPassword = UserPassword(password ?: StringFaker.password())

    fun random(): UserPassword = create(null)

}
