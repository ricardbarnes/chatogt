package cat.vonblum.chatogt.users.users

import cat.vonblum.chatogt.shared.domain.aggregate.AggregateRoot
import cat.vonblum.chatogt.users.shared.roles.Role

class User(
    val id: UserId,
    val name: UserName,
    val password: UserPassword,
    val role: Role
) : AggregateRoot() {

    companion object {

        fun create(
            id: UserId,
            name: UserName,
            password: UserPassword,
            role: Role
        ): User = User(id, name, password, role).also { user ->
            user.record(UserCreatedEvent(id.value, name.value, password.value, role.name))
        }

    }

}