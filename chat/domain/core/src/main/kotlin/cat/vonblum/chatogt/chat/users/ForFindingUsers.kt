package cat.vonblum.chatogt.chat.users

interface ForFindingUsers {

    fun findByName(name: UserName): User

}