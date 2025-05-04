package cat.vonblum.chatogt.usermanagement.users.find

import cat.vonblum.chatogt.shared.domain.query.Response
import java.util.UUID

class FindUserByNameResponse(
    val id: UUID,
    val name: String,
    val role: String
) : Response