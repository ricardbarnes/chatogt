package cat.vonblum.chatogt.chats.producer.mapper

import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaCommandMapper(private val gson: Gson) {

    fun <T> toDomain(json: String, clazz: Class<T>): T {
        return gson.fromJson(json, clazz)
    }

}