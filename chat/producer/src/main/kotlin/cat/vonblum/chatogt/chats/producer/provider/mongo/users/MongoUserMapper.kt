package cat.vonblum.chatogt.chats.producer.provider.mongo.users

import cat.vonblum.chatogt.chats.producer.provider.mongo.users.MongoUserProjection
import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.users.User
import cat.vonblum.chatogt.chats.users.UserName
import cat.vonblum.chatogt.chats.users.UserPassword
import org.springframework.stereotype.Component
import java.util.UUID
import java.util.stream.Collectors

@Component
class MongoUserMapper {

    fun map(projection: MongoUserProjection): User {
        return User(
            UserId(UUID.fromString(projection.id)),
            UserName(projection.name),
            UserPassword("hidden"),
            projection.contactIds.stream().map { UserId((UUID.fromString(it))) }.collect(Collectors.toSet()),
        )
    }

}