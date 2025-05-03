package cat.vonblum.chatogt.chats.producer.repository

import cat.vonblum.chatogt.chats.users.User
import cat.vonblum.chatogt.chats.users.UserName

interface UserRepository {

    fun findByName(name: UserName): User

}