package cat.vonblum.chatogt.chats.users

interface FindingUsers {

    fun findByName(name: UserName): User

}