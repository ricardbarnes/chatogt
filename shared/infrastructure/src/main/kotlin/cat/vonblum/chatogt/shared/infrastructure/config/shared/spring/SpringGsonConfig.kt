package cat.vonblum.chatogt.shared.infrastructure.config.shared.spring

import cat.vonblum.chatogt.shared.infrastructure.io.serializer.gson.GsonInstantTypeAdapter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Instant
import java.time.format.DateTimeFormatter

@Configuration
class SpringGsonConfig {

    @Bean
    fun gson(dateTimeFormatter: DateTimeFormatter): Gson {
        return GsonBuilder()
            .registerTypeAdapter(Instant::class.java, GsonInstantTypeAdapter(dateTimeFormatter))
            .create()
    }

}