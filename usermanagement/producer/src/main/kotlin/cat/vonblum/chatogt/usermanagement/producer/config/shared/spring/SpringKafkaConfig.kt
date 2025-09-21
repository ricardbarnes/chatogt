package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.shared.infrastructure.bus.shared.spring.SpringKafkaMessageSubscriber
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(SpringKafkaMessageSubscriber::class)
class SpringKafkaConfig