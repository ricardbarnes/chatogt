package cat.vonblum.chatogt.usermanagement.api.config.shared.springboot.bus.shared

import cat.vonblum.chatogt.shared.infrastructure.bus.command.kafka.KafkaMessageProducer
import cat.vonblum.chatogt.shared.infrastructure.bus.command.MessageProducer
import cat.vonblum.chatogt.usermanagement.api.bus.shared.kafka.KafkaTopicResolver
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaTemplate

@Configuration
@EnableConfigurationProperties(
    value = [
        SpringbootBusProperties::class,
    ]
)
class SpringbootBusConfig {

    @Bean
    fun kafkaTopicResolver(properties: SpringbootBusProperties): KafkaTopicResolver {
        return KafkaTopicResolver(properties)
    }

    @Bean
    fun kafkaMessageProducer(
        kafkaTemplate: KafkaTemplate<String, Any>,
        kafkaTopicResolver: KafkaTopicResolver
    ): MessageProducer {
        return KafkaMessageProducer(
            kafkaTemplate,
            kafkaTopicResolver::resolve
        )
    }

}
