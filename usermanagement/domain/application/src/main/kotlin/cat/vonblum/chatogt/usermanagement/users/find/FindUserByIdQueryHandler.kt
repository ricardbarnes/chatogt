package cat.vonblum.chatogt.usermanagement.users.find

import cat.vonblum.chatogt.usermanagement.users.ForFindingUsers
import cat.vonblum.chatogt.usermanagement.users.UserId
import cat.vonblum.chatogt.usermanagement.users.UserName
import java.util.UUID

class FindUserByIdQueryHandler(private val finding: ForFindingUsers) {

    fun handle(query: FindUserByIdQuery): FindUserByIdResponse =
        finding.findById(UserId(query.id)).let { user ->
            FindUserByIdResponse(
                user.id.value,
                user.name.value
            )
        }

}