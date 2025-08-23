package cat.vonblum.chatogt.chat.users

interface FindingUsers {

    fun findByName(name: UserName): User

}