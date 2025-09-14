package cat.vonblum.chatogt.usermanagement.api.config.shared.spring

import cat.vonblum.chatogt.shared.infrastructure.bus.command.MessageProducer
import cat.vonblum.chatogt.shared.infrastructure.bus.command.kafka.KafkaMessageProducer
import cat.vonblum.chatogt.shared.infrastructure.config.shared.spring.SpringKafkaConfig
import cat.vonblum.chatogt.usermanagement.api.bus.command.kafka.KafkaCommandBusResolver
import cat.vonblum.chatogt.usermanagement.api.bus.query.kafka.KafkaQueryBus
import cat.vonblum.chatogt.usermanagement.api.bus.query.kafka.KafkaQueryBusResolver
import cat.vonblum.chatogt.usermanagement.api.properties.users.SpringUserQueryBusProps
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.kafka.core.KafkaTemplate

@Configuration
@EnableConfigurationProperties(
    value = [
        SpringUserQueryBusProps::class,
    ]
)
@Import(
    value = [
        SpringKafkaConfig::class,
    ]
)
class SpringQueryBusKafkaConfig {

    @Bean
    fun kafkaQueryBusResolver(properties: SpringUserQueryBusProps): KafkaQueryBusResolver {
        return KafkaQueryBusResolver(properties)
    }

    @Bean
    fun kafkaMessageProducer(
        kafkaTemplate: KafkaTemplate<String, Any>,
        kafkaQueryBusResolver: KafkaQueryBusResolver
    ): MessageProducer {
        return KafkaMessageProducer(
            kafkaTemplate,
            kafkaQueryBusResolver::resolve
        )
    }

    @Bean
    fun kafkaQueryBus(messageProducer: MessageProducer): KafkaQueryBus {
        return KafkaQueryBus(messageProducer)
    }

}