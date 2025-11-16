package cat.vonblum.chatogt.usermanagement.api.config.shared.spring

import cat.vonblum.chatogt.shared.domain.command.CommandBus
import cat.vonblum.chatogt.shared.infrastructure.io.message.MessageProducer
import cat.vonblum.chatogt.usermanagement.api.bus.command.kafka.KafkaCommandBus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringBusConfig {

    @Bean
    fun commandBus(producer: MessageProducer): CommandBus {
        return KafkaCommandBus(producer);
    }

}