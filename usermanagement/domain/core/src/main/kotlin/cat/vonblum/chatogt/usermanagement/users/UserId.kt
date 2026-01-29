package cat.vonblum.chatogt.usermanagement.users

import cat.vonblum.chatogt.usermanagement.domain.valueobject.Id
import java.util.UUID

data class UserId(override val value: UUID) : Id(value)