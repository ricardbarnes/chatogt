package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.shared.domain.event.EventBus
import cat.vonblum.chatogt.shared.infrastructure.bus.shared.MessageResolver
import cat.vonblum.chatogt.shared.infrastructure.bus.shared.spring.SpringKafkaSubscriber
import cat.vonblum.chatogt.usermanagement.producer.bus.event.kafka.KafkaEventBus
import cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka.KafkaUserCommandHandler
import cat.vonblum.chatogt.usermanagement.producer.handler.query.users.kafka.KafkaUserQueryHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringKafkaConfig {

    @Bean
    fun eventBus(): EventBus {
        return KafkaEventBus()
    }

    @Bean
    fun kafkaMessageResolver(
        kafkaUserCommandHandler: KafkaUserCommandHandler,
        kafkaUserQueryHandler: KafkaUserQueryHandler,
    ): MessageResolver {
        TODO()
    }

    @Bean
    fun springKafkaSubscriber(messageResolver: MessageResolver): SpringKafkaSubscriber {
        return SpringKafkaSubscriber(messageResolver)
    }

}
