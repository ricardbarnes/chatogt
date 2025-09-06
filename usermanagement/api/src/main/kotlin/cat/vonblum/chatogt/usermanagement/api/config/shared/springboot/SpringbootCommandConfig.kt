package cat.vonblum.chatogt.usermanagement.api.config.shared.springboot

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(
    value = [
        SpringbootCommandBusProperties::class,
    ]
)
class SpringbootCommandConfig {

    // Command config for Springboot

}