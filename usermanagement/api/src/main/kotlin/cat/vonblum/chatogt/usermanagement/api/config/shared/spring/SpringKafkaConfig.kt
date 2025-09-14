package cat.vonblum.chatogt.usermanagement.api.config.shared.spring

import cat.vonblum.chatogt.shared.infrastructure.bus.command.MessageProducer
import cat.vonblum.chatogt.shared.infrastructure.bus.command.kafka.KafkaMessageProducer
import cat.vonblum.chatogt.shared.infrastructure.config.shared.spring.SpringKafkaConfig
import cat.vonblum.chatogt.usermanagement.api.bus.command.kafka.KafkaCommandBus
import cat.vonblum.chatogt.usermanagement.api.bus.command.kafka.KafkaCommandBusResolver
import cat.vonblum.chatogt.usermanagement.api.properties.users.SpringUserCommandBusProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.kafka.core.KafkaTemplate

@Configuration
@EnableConfigurationProperties(
    value = [
        SpringUserCommandBusProperties::class,
    ]
)
@Import(
    value = [
        SpringKafkaConfig::class,
    ]
)
class SpringKafkaConfig {

    @Bean
    fun kafkaCommandBusResolver(properties: SpringUserCommandBusProperties): KafkaCommandBusResolver {
        return KafkaCommandBusResolver(properties)
    }

    @Bean
    fun kafkaMessageProducer(
        kafkaTemplate: KafkaTemplate<String, Any>,
        kafkaCommandBusResolver: KafkaCommandBusResolver
    ): MessageProducer {
        return KafkaMessageProducer(
            kafkaTemplate,
            kafkaCommandBusResolver::resolve
        )
    }

    @Bean
    fun kafkaCommandBus(messageProducer: MessageProducer): KafkaCommandBus {
        return KafkaCommandBus(messageProducer)
    }

}
