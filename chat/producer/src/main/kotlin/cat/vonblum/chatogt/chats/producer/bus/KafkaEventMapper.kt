package cat.vonblum.chatogt.chats.producer.bus

import cat.vonblum.chatogt.shared.domain.event.Event
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaEventMapper(private val gson: Gson) {

    fun toDto(event: Event): String {
        return gson.toJson(event)
    }

}