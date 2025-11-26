package cat.vonblum.chatogt.usermanagement.users

interface UserNotifier {

    fun notify(event: UserCreatedEvent)

}