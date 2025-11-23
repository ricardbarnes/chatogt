package cat.vonblum.chatogt.chat.consumer.config.spring

import cat.vonblum.chatogt.usermanagement.infrastructure.config.spring.SpringKafkaConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackageClasses = [SpringKafkaConfig::class])
class SpringConsumerConfig