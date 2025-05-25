package cat.vonblum.chatogt.usermanagement.users

object UserPasswordMother {

    fun create(password: String?): UserPassword = UserPassword(password ?: "<PASSWORD>")

    fun random(): UserPassword = create(null)

}
