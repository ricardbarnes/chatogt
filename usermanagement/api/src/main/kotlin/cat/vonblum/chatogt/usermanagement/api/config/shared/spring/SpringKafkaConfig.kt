package cat.vonblum.chatogt.usermanagement.api.config.shared.spring

import cat.vonblum.chatogt.usermanagement.api.bus.command.kafka.KafkaCommandBus
import cat.vonblum.chatogt.usermanagement.api.bus.command.kafka.KafkaCommandMapper
import cat.vonblum.chatogt.usermanagement.api.bus.query.kafka.KafkaQueryBus
import cat.vonblum.chatogt.usermanagement.shared.config.spring.SpringBusProps
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaTemplate

@Configuration
@EnableConfigurationProperties(SpringBusProps::class)
class SpringKafkaConfig {

    @Bean
    fun kafkaCommandMapper(): KafkaCommandMapper {
        return KafkaCommandMapper()
    }

    @Bean
    fun kafkaCommandBus(
        kafkaTemplate: KafkaTemplate<String, ByteArray>,
        mapper: KafkaCommandMapper,
        props: SpringBusProps
    ): KafkaCommandBus {
        return KafkaCommandBus(
            kafkaTemplate,
            mapper,
            props,
        )
    }

    @Bean
    fun kafkaQueryBus(
        kafkaTemplate: KafkaTemplate<String, ByteArray>,
        mapper: KafkaCommandMapper,
        props: SpringBusProps
    ): KafkaQueryBus {
        return KafkaQueryBus(
            kafkaTemplate,
            mapper,
            props
        )
    }

}
