package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.chats.api.dto.RestChatDto
import cat.vonblum.chatogt.chats.chats.create.CreateChatCommand
import cat.vonblum.chatogt.chats.chats.delete.DeleteChatCommand
import cat.vonblum.chatogt.chats.chats.find.FindChatQuery
import cat.vonblum.chatogt.chats.chats.find.FindChatResponse
import cat.vonblum.chatogt.shared.domain.command.Command
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