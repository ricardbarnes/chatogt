package cat.vonblum.chatogt.chat.shared

import cat.vonblum.chatogt.usermanagement.domain.valueobject.Id
import java.util.UUID

class UserId(override val value: UUID) : Id(value)