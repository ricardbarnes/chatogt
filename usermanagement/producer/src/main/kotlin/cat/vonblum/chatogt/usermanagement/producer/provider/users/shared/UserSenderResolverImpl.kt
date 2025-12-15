package cat.vonblum.chatogt.usermanagement.producer.provider.users.shared

import cat.vonblum.chatogt.usermanagement.producer.provider.users.cia.CiaForSendingUsers
import cat.vonblum.chatogt.usermanagement.producer.provider.users.fbi.FbiForSendingUsers
import cat.vonblum.chatogt.usermanagement.users.ForSendingUsers
import cat.vonblum.chatogt.usermanagement.users.User
import cat.vonblum.chatogt.usermanagement.users.UserSenderResolver

class UserSenderResolverImpl(
    private val fbiForSendingUsers: FbiForSendingUsers,
    private val ciaForSendingUsers: CiaForSendingUsers,
) : UserSenderResolver {

    override fun resolveFor(user: User): ForSendingUsers {
        return if (user.isPoor()) {
            ciaForSendingUsers
        } else {
            fbiForSendingUsers
        }
    }

}