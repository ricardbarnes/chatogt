package cat.vonblum.chatogt.usermanagement.api.config.shared.spring

import cat.vonblum.chatogt.shared.infrastructure.bus.MessageEnvelope
import cat.vonblum.chatogt.shared.infrastructure.bus.command.MessageProducer
import cat.vonblum.chatogt.shared.infrastructure.bus.command.kafka.KafkaMessageProducer
import cat.vonblum.chatogt.shared.infrastructure.config.shared.spring.SpringKafkaConfig as SharedKafkaConfig
import cat.vonblum.chatogt.usermanagement.api.bus.command.kafka.KafkaCommandBus
import cat.vonblum.chatogt.usermanagement.api.bus.query.kafka.KafkaQueryBus
import cat.vonblum.chatogt.usermanagement.api.properties.users.SpringBusProps
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.kafka.core.KafkaTemplate

@Configuration
@Import(SharedKafkaConfig::class)
@EnableConfigurationProperties(SpringBusProps::class)
class SpringKafkaConfig {

    @Bean
    fun kafkaTopicResolver(busProps: SpringBusProps): SpringKafkaTopicResolver {
        return SpringKafkaTopicResolver(busProps)
    }

    @Bean
    fun kafkaMessageProducer(
        kafkaTemplate: KafkaTemplate<String, Any>,
        kafkaTopicResolver: SpringKafkaTopicResolver
    ): MessageProducer {
        return KafkaMessageProducer(
            kafkaTemplate,
            kafkaTopicResolver::resolve
        )
    }

    @Bean
    fun kafkaCommandBus(messageProducer: MessageProducer): KafkaCommandBus {
        return KafkaCommandBus(messageProducer)
    }

    @Bean
    fun kafkaQueryBus(messageProducer: MessageProducer): KafkaQueryBus {
        return KafkaQueryBus(messageProducer)
    }

}
