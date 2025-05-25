package cat.vonblum.chatogt.usermanagement.users

object UserStatusMother {

    fun active(): UserStatus = UserStatus.ACTIVE

    fun deleted(): UserStatus = UserStatus.DELETED

}