package cat.vonblum.chatogt.shared.infrastructure.io.serializer.gson

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type
import java.time.Instant
import java.time.format.DateTimeFormatter

class GsonInstantTypeAdapter(
    private val formatter: DateTimeFormatter
) : JsonSerializer<Instant>, JsonDeserializer<Instant> {

    override fun serialize(src: Instant?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        return JsonPrimitive(formatter.format(src))
    }

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Instant {
        return Instant.from(json?.asString?.let { formatter.parse(it) })
    }

}