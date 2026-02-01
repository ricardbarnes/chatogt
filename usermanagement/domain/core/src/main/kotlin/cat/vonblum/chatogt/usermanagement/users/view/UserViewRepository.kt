package cat.vonblum.chatogt.usermanagement.users.view

import cat.vonblum.chatogt.usermanagement.users.model.UserId

interface UserViewRepository {

    fun save(view: UserView)

    fun search(id: UserId): UserView?

}