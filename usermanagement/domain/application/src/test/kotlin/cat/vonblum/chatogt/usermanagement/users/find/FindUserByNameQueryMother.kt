package cat.vonblum.chatogt.usermanagement.users.find

import cat.vonblum.chatogt.shared.domain.valueobject.StringFaker

object FindUserByNameQueryMother {

    fun create(name: String?): FindUserByNameQuery =
        FindUserByNameQuery(name ?: StringFaker.name())

}
