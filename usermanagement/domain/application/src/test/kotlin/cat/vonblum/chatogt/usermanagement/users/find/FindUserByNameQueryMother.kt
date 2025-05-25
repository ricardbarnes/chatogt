package cat.vonblum.chatogt.usermanagement.users.find

import cat.vonblum.chatogt.shared.domain.valueobject.StringFaker

class FindUserByNameQueryMother {

    companion object {

        fun create(name: String?): FindUserByNameQuery =
            FindUserByNameQuery(name ?: StringFaker.name())

    }

}
