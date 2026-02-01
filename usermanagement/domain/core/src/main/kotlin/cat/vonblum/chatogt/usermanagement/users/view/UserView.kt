package cat.vonblum.chatogt.usermanagement.users.view

import cat.vonblum.chatogt.usermanagement.users.model.UserStatus
import java.util.UUID

data class UserView(
    val id: UUID,
    val email: String,
    var status: String,
    val type: String,
    val notificationTypes: List<String>
) {
    fun delete() = let { status = UserStatus.DELETED.name }
}