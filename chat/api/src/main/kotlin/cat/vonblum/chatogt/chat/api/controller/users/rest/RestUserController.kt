package cat.vonblum.chatogt.chat.api.controller

import cat.vonblum.chatogt.chat.api.controller.users.rest.RestUserChatIdsDto
import cat.vonblum.chatogt.chat.api.controller.users.rest.RestUserDto
import cat.vonblum.chatogt.chat.api.mapper.RestUserMapper
import cat.vonblum.chatogt.chat.chats.find.FindChatIdsByUserIdResponse
import cat.vonblum.chatogt.shared.domain.command.CommandBus
import cat.vonblum.chatogt.shared.domain.query.QueryBus
import cat.vonblum.chatogt.chat.users.find.FindUserByNameResponse
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/users")
class RestUserController(
    private val commandBus: CommandBus,
    private val queryBus: QueryBus,
    private val mapper: RestUserMapper
) {

    @PostMapping
    @ResponseStatus(CREATED)
    fun create(@RequestBody dto: RestUserDto) {
        commandBus.dispatch(mapper.toCreateCommand(dto))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    fun delete(@PathVariable id: UUID) {
        commandBus.dispatch(mapper.toDeleteCommand(id))
    }

    @PutMapping
    @ResponseStatus(OK)
    fun update(@RequestBody dto: RestUserDto) {
        commandBus.dispatch(mapper.toUpdateCommand(dto))
    }

    @GetMapping("/{id}/chats")
    fun findChatsByUserId(@PathVariable id: UUID): RestUserChatIdsDto {
        return queryBus.ask(mapper.toFindByUserIdQuery(id))
            ?.let { mapper.toDto(it as FindChatIdsByUserIdResponse) }
            ?: throw ResponseStatusException(
                NOT_FOUND,
                "Chats not found for user with ID: $id"
            )
    }

    @GetMapping
    fun findByName(@RequestParam name: String): RestUserDto {
        return queryBus.ask(mapper.toFindByNameQuery(name))
            ?.let { mapper.toDto(it as FindUserByNameResponse) }
            ?: throw ResponseStatusException(
                NOT_FOUND,
                "User not found with name: $name"
            )
    }

}