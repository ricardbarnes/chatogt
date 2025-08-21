package cat.vonblum.chatogt.usermanagement.users.find

import cat.vonblum.chatogt.usermanagement.users.FindingUsers
import cat.vonblum.chatogt.usermanagement.users.UserName

class FindUserByIdQueryHandler(private val finding: FindingUsers) {

    fun handle(query: FindUserByIdQuery): FindUserByIdResponse =
        finding.findByName(UserName(query.id)).let { user ->
            FindUserByIdResponse(
                user.id.value,
                user.name.value
            )
        }

}