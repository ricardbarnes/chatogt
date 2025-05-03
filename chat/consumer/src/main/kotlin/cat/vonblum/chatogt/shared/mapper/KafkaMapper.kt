package cat.vonblum.chatogt.shared.mapper

import cat.vonblum.chatogt.shared.domain.event.Event
import com.google.gson.Gson
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.stereotype.Component
import java.util.*

@Component
class KafkaMapper(private val gson: Gson) {

    fun toDomain(record: ConsumerRecord<UUID, String>): Event {
        val className = getType(record)
        val clazz = Class.forName(className).asSubclass(Event::class.java)
        return gson.fromJson(record.value(), clazz)
    }

    private fun getType(record: ConsumerRecord<UUID, String>): String? {
        return record.headers()
            .lastHeader("type")
            ?.value()
            ?.toString(Charsets.UTF_8)
    }

}
