package cat.vonblum.chatogt.chat.consumer.config

import cat.vonblum.chatogt.shared.infrastructure.config.shared.spring.SpringKafkaConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackageClasses = [SpringKafkaConfig::class])
class SpringConsumerConfig