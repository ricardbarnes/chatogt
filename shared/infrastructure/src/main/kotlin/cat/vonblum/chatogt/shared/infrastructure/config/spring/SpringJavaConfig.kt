package cat.vonblum.chatogt.shared.infrastructure.config.spring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.format.DateTimeFormatter

@Configuration
class SpringJavaConfig {

    @Bean
    fun dateTimeFormatter(): DateTimeFormatter {
        return DateTimeFormatter.ISO_INSTANT
    }

}