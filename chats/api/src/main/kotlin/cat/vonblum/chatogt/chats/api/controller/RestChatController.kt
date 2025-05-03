package cat.vonblum.chatogt.chats.api.controller

import cat.vonblum.chatogt.chats.api.dto.RestChatDto
import cat.vonblum.chatogt.chats.api.mapper.RestChatMapper
import cat.vonblum.chatogt.chats.chats.find.FindChatResponse
import cat.vonblum.chatogt.shared.domain.command.CommandBus
import cat.vonblum.chatogt.shared.domain.query.QueryBus
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/chats")
class RestChatController(
    private val commandBus: CommandBus,
    private val queryBus: QueryBus,
    private val mapper: RestChatMapper
) {

    @PostMapping
    @ResponseStatus(CREATED)
    fun create(@RequestBody dto: RestChatDto) {
        commandBus.dispatch(mapper.toCreateCommand(dto))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    fun delete(@PathVariable id: UUID) {
        commandBus.dispatch(mapper.toDeleteCommand(id))
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    fun find(@PathVariable id: UUID): RestChatDto {
        val query = mapper.toFindQuery(id)
        val response = queryBus.ask(query)
        return mapper.toRest(response as FindChatResponse)
    }

    @PutMapping
    @ResponseStatus(OK)
    fun update(@RequestBody dto: RestChatDto) {
        commandBus.dispatch(mapper.toUpdateCommand(dto))
    }

}
