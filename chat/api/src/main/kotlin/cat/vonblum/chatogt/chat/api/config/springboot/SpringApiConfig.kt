package cat.vonblum.chatogt.chat.api.config.springboot

import cat.vonblum.chatogt.shared.infrastructure.config.spring.SpringSharedKafkaConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackageClasses = [SpringSharedKafkaConfig::class])
class SpringApiConfig