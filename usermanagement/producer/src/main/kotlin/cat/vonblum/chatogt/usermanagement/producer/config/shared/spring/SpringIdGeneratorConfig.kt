package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.usermanagement.domain.generator.IdGenerator
import cat.vonblum.chatogt.usermanagement.infrastructure.generator.java.UuidIdGenerator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringIdGeneratorConfig {

    @Bean
    fun idGenerator(): IdGenerator {
        return UuidIdGenerator()
    }

}