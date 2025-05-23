package cat.vonblum.chatogt.usermanagement.users

class UserPasswordMother {

    companion object {

        fun create(password: String?): UserPassword = UserPassword(password ?: "<PASSWORD>")

    }

}