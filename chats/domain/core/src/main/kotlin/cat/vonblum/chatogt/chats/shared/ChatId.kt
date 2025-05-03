package cat.vonblum.chatogt.chats.shared

import cat.vonblum.chatogt.shared.domain.valueobject.Id
import java.util.*

class ChatId(override val value: UUID) : Id(value)