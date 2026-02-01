package cat.vonblum.chatogt.usermanagement.users.port

import cat.vonblum.chatogt.usermanagement.users.aggregate.User

interface ForNotifyingUsers {

    fun notify(user: User)

}