package cat.vonblum.chatogt.users.users

interface FindingUsers {

    fun findByName(name: UserName): User

}