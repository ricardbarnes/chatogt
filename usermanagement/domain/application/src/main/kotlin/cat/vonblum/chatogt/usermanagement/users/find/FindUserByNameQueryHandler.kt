package cat.vonblum.chatogt.usermanagement.users.find

import cat.vonblum.chatogt.usermanagement.users.FindingUsers
import cat.vonblum.chatogt.usermanagement.users.UserName

class FindUserByNameQueryHandler(private val finding: FindingUsers) {

    fun handle(query: FindUserByNameQuery): FindUserByNameResponse =
        finding.findByName(UserName(query.name)).let { user ->
            FindUserByNameResponse(
                user.id.value,
                user.name.value
            )
        }

}