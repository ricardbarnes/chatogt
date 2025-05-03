package cat.vonblum.chatogt.users.users.find

import cat.vonblum.chatogt.users.users.FindingUsers
import cat.vonblum.chatogt.users.users.UserName

class FindUserByNameQueryHandler(private val finding: FindingUsers) {

    fun handle(query: FindUserByNameQuery): FindUserByNameResponse =
        finding.findByName(UserName(query.name)).let { user ->
            FindUserByNameResponse(
                user.id.value,
                user.name.value,
                user.role.name
            )
        }

}