package cat.vonblum.chatogt.usermanagement.api.config.shared.spring

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan("cat.vonblum.chatogt.usermanagement.api.controller.users.grpc")
class SpringConfig