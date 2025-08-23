package cat.vonblum.chatogt.chat.api.controller.users.rest

import java.util.UUID

class RestUserDto {
    var id: UUID? = null
    var name: String = ""
    var password: String = ""
    var contactIds: List<UUID>? = emptyList()
}