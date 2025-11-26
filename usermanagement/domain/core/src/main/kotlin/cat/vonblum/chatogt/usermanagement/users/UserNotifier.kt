package cat.vonblum.chatogt.usermanagement.users

interface UserNotifier {

    fun notifyCreation(user: User)

}