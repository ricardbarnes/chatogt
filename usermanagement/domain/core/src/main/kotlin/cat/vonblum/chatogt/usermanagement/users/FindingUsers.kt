package cat.vonblum.chatogt.usermanagement.users

interface FindingUsers {

    fun findByName(name: UserName): User

}