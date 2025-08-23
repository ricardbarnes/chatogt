package cat.vonblum.chatogt.chat.api.controller.users.rest

import com.fasterxml.jackson.annotation.JsonCreator
import java.util.UUID

class RestUserChatIdsDto @JsonCreator constructor(
    val id: UUID?,
    val chatIds: List<String>,
)