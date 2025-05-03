package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.chats.api.dto.RestUserChatIdsDto
import cat.vonblum.chatogt.chats.api.dto.RestUserDto
import cat.vonblum.chatogt.chats.chats.find.FindChatIdsByUserIdQuery
import cat.vonblum.chatogt.chats.chats.find.FindChatIdsByUserIdResponse
import cat.vonblum.chatogt.shared.domain.command.Command
import cat.vonblum.chatogt.chats.users.create.CreateUserCommand
import cat.vonblum.chatogt.chats.users.delete.DeleteUserCommand
import cat.vonblum.chatogt.chats.users.find.FindUserByNameQuery
import cat.vonblum.chatogt.chats.users.find.FindUserByNameResponse
import org.springframework.stereotype.Component
import java.util.*

@Component
class RestUserMapper {

    fun toCreateCommand(dto: RestUserDto): CreateUserCommand {
        return CreateUserCommand(
            dto.name,
            dto.password
        )
    }

    fun toDeleteCommand(id: UUID): DeleteUserCommand {
        TODO()
    }

    fun toUpdateCommand(dto: RestUserDto): Command {
        TODO()
    }

    fun toFindByUserIdQuery(id: UUID): FindChatIdsByUserIdQuery {
        return FindChatIdsByUserIdQuery(id)
    }

    fun toFindByNameQuery(name: String): FindUserByNameQuery {
        return FindUserByNameQuery(name)
    }

    fun toDto(response: FindUserByNameResponse): RestUserDto {
        val dto = RestUserDto()
        dto.id = response.id
        return dto
    }

    fun toDto(response: FindChatIdsByUserIdResponse): RestUserChatIdsDto {
        return RestUserChatIdsDto(
            response.userId,
            response.chatIds.map { it.toString() }.toList()
        )
    }

}