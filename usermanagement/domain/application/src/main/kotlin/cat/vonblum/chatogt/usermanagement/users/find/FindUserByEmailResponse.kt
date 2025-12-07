package cat.vonblum.chatogt.usermanagement.users.find

import cat.vonblum.chatogt.usermanagement.domain.query.Response
import java.util.UUID

data class FindUserByEmailResponse(
    val id: UUID,
    val email: String
) : Response