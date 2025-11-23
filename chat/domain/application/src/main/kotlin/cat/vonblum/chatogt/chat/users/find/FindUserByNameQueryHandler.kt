package cat.vonblum.chatogt.chat.users.find

import cat.vonblum.chatogt.usermanagement.domain.command.CommandHandler
import cat.vonblum.chatogt.chat.users.ForFindingUsers
import cat.vonblum.chatogt.chat.users.UserName

class FindUserByNameQueryHandler(private val finding: ForFindingUsers) : CommandHandler {

    fun handle(query: FindUserByNameQuery): FindUserByNameResponse =
        finding.findByName(UserName(query.name)).let { user ->
            FindUserByNameResponse(
                user.id.value,
                user.name.value
            )
        }

}