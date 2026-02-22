package cat.vonblum.chatogt.usermanagement.consumer.repository.users.psql

import cat.vonblum.chatogt.usermanagement.users.model.UserId
import cat.vonblum.chatogt.usermanagement.users.view.UserView
import cat.vonblum.chatogt.usermanagement.users.view.UserViewRepository

class PsqlUserViewRepository : UserViewRepository {

    override fun save(view: UserView) {
        TODO("Not yet implemented")
    }

    override fun search(id: UserId): UserView {
        TODO("Not yet implemented")
    }

}