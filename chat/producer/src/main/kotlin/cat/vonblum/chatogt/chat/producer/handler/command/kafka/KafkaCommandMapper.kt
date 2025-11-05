package cat.vonblum.chatogt.chat.producer.handler.command.kafka

import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaCommandMapper(private val gson: Gson) {

    fun <T> toDomain(json: String, clazz: Class<T>): T {
        return gson.fromJson(json, clazz)
    }

}