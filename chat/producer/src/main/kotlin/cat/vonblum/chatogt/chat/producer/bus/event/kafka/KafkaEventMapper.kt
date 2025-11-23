package cat.vonblum.chatogt.chat.producer.bus.event.kafka

import cat.vonblum.chatogt.usermanagement.domain.event.Event
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaEventMapper(private val gson: Gson) {

    fun toDto(event: Event): String {
        return gson.toJson(event)
    }

}