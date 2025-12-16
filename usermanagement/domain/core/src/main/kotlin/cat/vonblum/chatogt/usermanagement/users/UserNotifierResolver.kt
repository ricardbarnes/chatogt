package cat.vonblum.chatogt.usermanagement.users

interface UserNotifierResolver {

    fun resolveAllFor(user: User): Set<ForNotifyingUsers>

}