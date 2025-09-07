package cat.vonblum.chatogt.usermanagement.api.config.shared.springboot.command

import cat.vonblum.chatogt.shared.infrastructure.bus.command.kafka.KafkaMessageProducer
import cat.vonblum.chatogt.shared.infrastructure.bus.command.shared.MessageProducer
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(
    value = [
        SpringbootCommandBusProperties::class,
    ]
)
class SpringbootCommandBusConfig {

    fun messageProducer(): MessageProducer {
        TODO()
        //        return KafkaMessageProducer()
    }

}