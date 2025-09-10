package cat.vonblum.chatogt.usermanagement.api.config.shared.springboot.bus.command

import cat.vonblum.chatogt.shared.infrastructure.bus.command.kafka.KafkaMessageProducer
import cat.vonblum.chatogt.shared.infrastructure.bus.command.MessageProducer
import cat.vonblum.chatogt.usermanagement.api.bus.shared.command.kafka.KafkaCommandTopicResolver
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
    fun kafkaCommandTopicResolver(properties: SpringbootCommandBusProperties): KafkaCommandTopicResolver {
        return KafkaCommandTopicResolver(properties)
    }

    @Bean
    fun kafkaMessageProducer(
        kafkaTemplate: KafkaTemplate<String, Any>,
        kafkaCommandTopicResolver: KafkaCommandTopicResolver
    ): MessageProducer {
        return KafkaMessageProducer(
            kafkaTemplate,
            kafkaCommandTopicResolver::resolve
        )
    }

}