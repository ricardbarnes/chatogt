package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.users.model.UserType

object UserTypeMother {

    fun standard(): UserType = UserType.STANDARD

    fun premium(): UserType = UserType.PREMIUM

}