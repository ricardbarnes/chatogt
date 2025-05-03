package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.shared.domain.command.Command
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaCommandMapper(private val gson: Gson) {

    fun toDto(command: Command): String = gson.toJson(command)

}