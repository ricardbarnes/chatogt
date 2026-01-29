package cat.vonblum.chatogt.usermanagement.users.find

import cat.vonblum.chatogt.usermanagement.users.ForFindingUsers
import cat.vonblum.chatogt.usermanagement.users.UserEmail

class FindUserByEmailQueryHandler(private val finding: ForFindingUsers) {

    fun handle(query: FindUserByEmailQuery): FindUserByEmailResponse =
        finding.findByEmail(UserEmail(query.email)).let { user ->
            FindUserByEmailResponse(
                user.id().value,
                user.email().value
            )
        }

}