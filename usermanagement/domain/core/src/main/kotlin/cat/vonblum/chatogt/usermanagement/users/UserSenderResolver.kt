package cat.vonblum.chatogt.usermanagement.users

interface UserSenderResolver {

    fun resolveFor(user: User): ForSendingUsers

}