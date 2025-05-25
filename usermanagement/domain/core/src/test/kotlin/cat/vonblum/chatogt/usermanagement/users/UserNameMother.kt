package cat.vonblum.chatogt.usermanagement.users

object UserNameMother {

    fun create(name: String?): UserName = UserName(name ?: "TestName")

    fun random(): UserName = create(null)

}