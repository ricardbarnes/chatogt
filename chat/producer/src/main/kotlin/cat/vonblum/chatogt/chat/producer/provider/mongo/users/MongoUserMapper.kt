package cat.vonblum.chatogt.chat.producer.provider.mongo.users

import cat.vonblum.chatogt.chat.shared.UserId
import cat.vonblum.chatogt.chat.users.User
import cat.vonblum.chatogt.chat.users.UserName
import cat.vonblum.chatogt.chat.users.UserPassword
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