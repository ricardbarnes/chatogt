package cat.vonblum.chatogt.usermanagement.api.config.shared.spring

import cat.vonblum.chatogt.shared.infrastructure.config.shared.spring.SpringKafkaConfig
import cat.vonblum.chatogt.usermanagement.api.properties.users.SpringUserQueryBusProps
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@EnableConfigurationProperties(
    value = [
        SpringUserQueryBusProps::class,
    ]
)
@Import(
    value = [
        SpringKafkaConfig::class,
    ]
)
class SpringQueryBusKafkaConfig {

    // TODO

}