package cat.vonblum.chatogt.usermanagement.users.find

import cat.vonblum.chatogt.shared.domain.query.Response
import java.util.UUID

class FindUserByIdResponse(
    val id: UUID,
    val name: String
) : Response