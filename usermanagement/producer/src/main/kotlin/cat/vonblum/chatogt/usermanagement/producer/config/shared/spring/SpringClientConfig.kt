package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.usermanagement.producer.clients.cia.Auth0Client
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringClientConfig {

    @Bean
    fun auth0Client(): Auth0Client {
        return Auth0Client()
    }

}