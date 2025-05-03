package cat.vonblum.chatogt.users.producer.adapter.users

import cat.vonblum.chatogt.shared.infrastructure.annotation.DrivenAdapter
import cat.vonblum.chatogt.users.users.DeletingUsers
import cat.vonblum.chatogt.users.users.UserId
import org.springframework.stereotype.Component

@DrivenAdapter
@Component
class MongoDeletingUsers : DeletingUsers {

    override fun deleteById(id: UserId) {
        TODO("Not yet implemented")
    }

}