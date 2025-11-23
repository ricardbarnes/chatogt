package cat.vonblum.chatogt.chat.api.bus.shared.command.kafka

import cat.vonblum.chatogt.usermanagement.domain.command.Command
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaCommandMapper(private val gson: Gson) {

    fun toDto(command: Command): String = gson.toJson(command)

}