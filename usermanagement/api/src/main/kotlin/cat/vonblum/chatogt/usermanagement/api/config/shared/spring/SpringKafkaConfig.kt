package cat.vonblum.chatogt.usermanagement.api.config.shared.spring

import cat.vonblum.chatogt.shared.infrastructure.bus.command.MessageProducer
import cat.vonblum.chatogt.shared.infrastructure.bus.command.kafka.KafkaMessageProducer
import cat.vonblum.chatogt.shared.infrastructure.config.shared.spring.SpringKafkaConfig
import cat.vonblum.chatogt.usermanagement.api.bus.command.kafka.KafkaCommandBus
import cat.vonblum.chatogt.usermanagement.api.bus.shared.kafka.KafkaTopicResolver
import cat.vonblum.chatogt.usermanagement.api.properties.users.SpringUserProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.kafka.core.KafkaTemplate

@Configuration
@EnableConfigurationProperties(
    value = [
        SpringUserProperties::class,
    ]
)
@Import(
    value = [
        SpringKafkaConfig::class,
    ]
)
class SpringKafkaConfig {

    @Bean
    fun kafkaTopicResolver(properties: SpringUserProperties): KafkaTopicResolver {
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

    @Bean
    fun kafkaCommandBus(messageProducer: KafkaMessageProducer): KafkaCommandBus {
        return KafkaCommandBus(messageProducer)
    }

}
