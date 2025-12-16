package cat.vonblum.chatogt.usermanagement.users

interface UserNotifierResolver {

    fun resolveFor(user: User): Set<ForNotifyingUsers>

}