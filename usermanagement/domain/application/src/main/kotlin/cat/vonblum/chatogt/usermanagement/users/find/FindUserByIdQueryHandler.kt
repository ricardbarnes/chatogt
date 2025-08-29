package cat.vonblum.chatogt.usermanagement.users.find

import cat.vonblum.chatogt.usermanagement.users.ForFindingUsers
import cat.vonblum.chatogt.usermanagement.users.UserName

class FindUserByIdQueryHandler(private val finding: ForFindingUsers) {

    fun handle(query: FindUserByIdQuery): FindUserByIdResponse =
        finding.findByName(UserName(query.id)).let { user ->
            FindUserByIdResponse(
                user.id.value,
                user.name.value
            )
        }

}