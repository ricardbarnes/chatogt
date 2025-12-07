package cat.vonblum.chatogt.usermanagement.users.find

import cat.vonblum.chatogt.usermanagement.domain.query.Query
import java.util.UUID

data class FindUserByIdQuery(val id: UUID) : Query