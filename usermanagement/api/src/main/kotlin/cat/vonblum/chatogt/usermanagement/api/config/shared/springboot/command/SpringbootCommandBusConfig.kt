package cat.vonblum.chatogt.usermanagement.api.config.shared.springboot.command

import cat.vonblum.chatogt.shared.infrastructure.bus.command.kafka.KafkaMessageProducer
import cat.vonblum.chatogt.shared.infrastructure.bus.command.shared.MessageProducer
import cat.vonblum.chatogt.shared.infrastructure.bus.command.kafka.KafkaTopicResolver
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaTemplate

@Configuration
@EnableConfigurationProperties(
    value = [
        SpringbootCommandBusProperties::class,
    ]
)
class SpringbootCommandBusConfig {

    @Bean
    fun kafkaCommandTopicResolver(): KafkaTopicResolver {
        return KafkaTopicResolver()
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