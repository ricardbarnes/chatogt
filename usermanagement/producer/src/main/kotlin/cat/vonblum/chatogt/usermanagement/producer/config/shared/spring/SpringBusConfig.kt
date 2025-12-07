package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.usermanagement.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.producer.bus.event.kafka.KafkaEventBus
import cat.vonblum.chatogt.usermanagement.producer.bus.event.kafka.KafkaEventMapper
import cat.vonblum.chatogt.usermanagement.shared.config.spring.SpringBusProps
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaTemplate
import kotlin.String

@Configuration
@EnableConfigurationProperties(SpringBusProps::class)
class SpringBusConfig {

    @Bean
    fun kafkaEventMapper(): KafkaEventMapper {
        return KafkaEventMapper()
    }

    @Bean
    fun kafkaEventBus(
        template: KafkaTemplate<String, ByteArray>,
        mapper: KafkaEventMapper,
        props: SpringBusProps
    ): EventBus {
        return KafkaEventBus(
            template,
            mapper,
            props
        )
    }

}
