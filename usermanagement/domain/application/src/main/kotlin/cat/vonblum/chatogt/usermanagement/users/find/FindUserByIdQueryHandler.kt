package cat.vonblum.chatogt.usermanagement.users.find

import cat.vonblum.chatogt.usermanagement.domain.query.QueryHandler
import cat.vonblum.chatogt.usermanagement.users.port.ForFindingUsers
import cat.vonblum.chatogt.usermanagement.users.aggregate.UserId

class FindUserByIdQueryHandler(private val finding: ForFindingUsers) : QueryHandler {

    fun handle(query: FindUserByIdQuery): FindUserByIdResponse =
        finding.findById(UserId(query.id)).let { user ->
            FindUserByIdResponse(
                user.id().value,
                user.email().value
            )
        }

}