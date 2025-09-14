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
@EnableConfigurationProperties(
    value = [
        SpringBusProps::class,
    ]
)
class SpringKafkaConfig {

    @Bean
    fun kafkaMessageProducer(
        kafkaTemplate: KafkaTemplate<String, Any>,
        busProps: SpringBusProps
    ): MessageProducer {
        return KafkaMessageProducer(kafkaTemplate, createTopicResolver(busProps))
    }

    @Bean
    fun kafkaCommandBus(messageProducer: MessageProducer): KafkaCommandBus {
        return KafkaCommandBus(messageProducer)
    }

    @Bean
    fun kafkaQueryBus(messageProducer: MessageProducer): KafkaQueryBus {
        return KafkaQueryBus(messageProducer)
    }

    private fun createTopicResolver(busProps: SpringBusProps): (MessageEnvelope) -> String = { envelope ->
        val busMap = when (envelope.type.lowercase()) {
            "command" -> busProps.commands
            "query" -> busProps.queries
            "response" -> busProps.responses
            else -> throw IllegalArgumentException("Unsupported envelope type '${envelope.type}'")
        }

        busMap[envelope.aggregate.lowercase()]?.kafka?.topic
            ?: throw IllegalStateException("No config for aggregate '${envelope.aggregate}' and type '${envelope.type}'")
    }

}
