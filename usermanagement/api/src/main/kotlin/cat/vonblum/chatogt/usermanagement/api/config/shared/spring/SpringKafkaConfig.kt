package cat.vonblum.chatogt.usermanagement.api.config.shared.spring

import cat.vonblum.chatogt.shared.infrastructure.io.message.MessageProducer
import cat.vonblum.chatogt.usermanagement.api.bus.command.spring.SpringKafkaMessageProducer
import cat.vonblum.chatogt.usermanagement.api.bus.command.kafka.KafkaCommandBus
import cat.vonblum.chatogt.usermanagement.api.bus.command.kafka.KafkaCommandMapper
import cat.vonblum.chatogt.usermanagement.api.bus.query.kafka.KafkaQueryBus
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.kafka.core.KafkaTemplate
import cat.vonblum.chatogt.shared.infrastructure.config.spring.SpringKafkaConfig as SharedKafkaConfig

@Configuration
@Import(SharedKafkaConfig::class)
@EnableConfigurationProperties(SpringBusProps::class)
class SpringKafkaConfig {

    @Bean
    fun kafkaTopicResolver(busProps: SpringBusProps): SpringKafkaTopicResolver {
        return SpringKafkaTopicResolver(busProps)
    }

    @Bean
    fun kafkaCommandMapper(): KafkaCommandMapper {
        return KafkaCommandMapper()
    }

    @Bean
    fun kafkaMessageProducer(
        kafkaTemplate: KafkaTemplate<ByteArray, ByteArray>,
        kafkaTopicResolver: SpringKafkaTopicResolver,
        kafkaCommandMapper: KafkaCommandMapper
    ): MessageProducer {
        return SpringKafkaMessageProducer(
            kafkaTemplate,
            kafkaTopicResolver::resolve,
            kafkaCommandMapper
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
