package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.shared.domain.command.Command
import cat.vonblum.chatogt.shared.domain.event.EventBus
import cat.vonblum.chatogt.shared.infrastructure.bus.shared.MessageEnvelope
import cat.vonblum.chatogt.shared.infrastructure.bus.shared.spring.SpringKafkaMessageSubscriber
import cat.vonblum.chatogt.shared.infrastructure.handler.command.CommandDispatcher
import cat.vonblum.chatogt.usermanagement.producer.bus.event.kafka.KafkaEventBus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringKafkaConfig {

    @Bean
    fun eventBus(): EventBus {
        return KafkaEventBus()
    }

    /**
     * Kafka subscriber for user commands. Consumes messages from Kafka, maps to Command,
     * and dispatches them via CommandDispatcher.
     */
    @Bean
    fun userCommandSubscriber(commandDispatcher: CommandDispatcher): SpringKafkaMessageSubscriber {
        return SpringKafkaMessageSubscriber(
            handler = { envelope: MessageEnvelope ->
                val command = envelope.payload as? Command
                    ?: throw IllegalArgumentException("Payload is not a Command: ${envelope.payload}")
                commandDispatcher.send(command)
            }
        )
    }

}
