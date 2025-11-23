package cat.vonblum.chatogt.chat.api.config.springboot

import cat.vonblum.chatogt.usermanagement.infrastructure.config.spring.SpringKafkaConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackageClasses = [SpringKafkaConfig::class])
class SpringApiConfig