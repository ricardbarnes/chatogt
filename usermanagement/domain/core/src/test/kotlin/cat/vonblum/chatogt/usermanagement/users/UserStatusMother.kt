package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.users.aggregate.UserStatus

object UserStatusMother {

    fun active(): UserStatus = UserStatus.ACTIVE

    fun deleted(): UserStatus = UserStatus.DELETED

}