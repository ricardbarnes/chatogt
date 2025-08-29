package cat.vonblum.chatogt.usermanagement.users

interface ForFindingUsers {

    fun findById(id: UserId): User

    fun findByName(name: UserName): User

}