package cat.vonblum.chatogt.chat.users.find

import cat.vonblum.chatogt.usermanagement.domain.query.Response
import java.util.UUID

class FindUserByNameResponse(
    val id: UUID,
    val name: String,
) : Response