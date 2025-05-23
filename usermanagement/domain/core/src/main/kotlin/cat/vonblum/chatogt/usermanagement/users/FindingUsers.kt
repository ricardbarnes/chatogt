package cat.vonblum.chatogt.usermanagement.users

interface FindingUsers {

    fun findById(id: UserId): User

    fun findByName(name: UserName): User

}