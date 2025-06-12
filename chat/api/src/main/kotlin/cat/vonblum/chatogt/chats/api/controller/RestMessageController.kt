package cat.vonblum.chatogt.chats.api.controller

import cat.vonblum.chatogt.chats.api.dto.RestMessageDto
import cat.vonblum.chatogt.chats.api.mapper.RestMessageMapper
import cat.vonblum.chatogt.shared.domain.annotation.DriverAdapter
import cat.vonblum.chatogt.shared.domain.command.CommandBus
import cat.vonblum.chatogt.shared.domain.query.QueryBus
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.*
import java.util.*

@DriverAdapter
@RestController
@RequestMapping("/messages")
class RestMessageController(
    private val commandBus: CommandBus,
    private val queryBus: QueryBus,
    private val mapper: RestMessageMapper
) {

    @PostMapping
    @ResponseStatus(CREATED)
    fun create(@RequestBody dto: RestMessageDto) {
        commandBus.dispatch(mapper.toCreateCommand(dto))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    fun delete(@PathVariable id: UUID) {
        commandBus.dispatch(mapper.toDeleteCommand(id))
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    fun find(@PathVariable id: UUID): RestMessageDto {
        return mapper.toRest(queryBus.ask(mapper.toFindQuery(id)))
    }

    @PutMapping
    @ResponseStatus(OK)
    fun update(@RequestBody dto: RestMessageDto) {
        commandBus.dispatch(mapper.toUpdateCommand(dto))
    }

}