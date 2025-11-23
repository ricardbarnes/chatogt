package cat.vonblum.chatogt.chat.api.mapper

import cat.vonblum.chatogt.chat.api.controller.chats.rest.RestChatDto
import cat.vonblum.chatogt.chat.chats.create.CreateChatCommand
import cat.vonblum.chatogt.chat.chats.delete.DeleteChatCommand
import cat.vonblum.chatogt.chat.chats.find.FindChatQuery
import cat.vonblum.chatogt.chat.chats.find.FindChatResponse
import cat.vonblum.chatogt.usermanagement.domain.command.Command
import org.springframework.stereotype.Component
import java.util.*

@Component
class RestChatMapper {

    fun toCreateCommand(dto: RestChatDto): CreateChatCommand {
        return CreateChatCommand(dto.participantIds)
    }

    fun toDeleteCommand(id: UUID): DeleteChatCommand {
        return DeleteChatCommand(id)
    }

    fun toFindQuery(userId: UUID): FindChatQuery {
        return FindChatQuery(userId)
    }

    fun toUpdateCommand(dto: RestChatDto): Command {
        TODO()
    }

    fun toRest(response: FindChatResponse): RestChatDto {
        return RestChatDto(
            response.id,
            response.participantIds,
        )
    }

}