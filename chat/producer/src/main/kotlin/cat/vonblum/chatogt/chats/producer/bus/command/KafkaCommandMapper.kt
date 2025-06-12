package cat.vonblum.chatogt.chats.producer.bus.command

import cat.vonblum.chatogt.shared.domain.annotation.DriverAdapter
import com.google.gson.Gson
import org.springframework.stereotype.Component

@DriverAdapter
@Component
class KafkaCommandMapper(private val gson: Gson) {

    fun <T> toDomain(json: String, clazz: Class<T>): T {
        return gson.fromJson(json, clazz)
    }

}