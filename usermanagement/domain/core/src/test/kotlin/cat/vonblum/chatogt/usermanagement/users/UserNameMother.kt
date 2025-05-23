package cat.vonblum.chatogt.usermanagement.users

class UserNameMother {

    companion object {

        fun create(name: String?): UserName = UserName(name ?: "TestName")

    }

}