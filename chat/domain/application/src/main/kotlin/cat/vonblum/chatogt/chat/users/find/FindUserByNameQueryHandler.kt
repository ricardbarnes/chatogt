package cat.vonblum.chatogt.chat.users.find

import cat.vonblum.chatogt.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.chat.users.FindingUsers
import cat.vonblum.chatogt.chat.users.UserName

class FindUserByNameQueryHandler(private val finding: FindingUsers) : CommandHandler {

    fun handle(query: FindUserByNameQuery): FindUserByNameResponse =
        finding.findByName(UserName(query.name)).let { user ->
            FindUserByNameResponse(
                user.id.value,
                user.name.value
            )
        }

}