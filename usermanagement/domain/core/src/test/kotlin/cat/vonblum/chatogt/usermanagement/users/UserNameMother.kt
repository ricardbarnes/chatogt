package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.domain.valueobject.StringFaker

object UserNameMother {

    fun create(name: String?): UserName = UserName(name ?: StringFaker.name())

    fun random(): UserName = create(null)

}