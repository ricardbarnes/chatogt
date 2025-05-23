package cat.vonblum.chatogt.usermanagement.users.find

class FindUserByNameQueryMother {

    companion object {

        fun create(name: String?): FindUserByNameQuery =
            FindUserByNameQuery(name ?: "defaultName")

    }

}
