package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.usermanagement.producer.clients.cia.CiaClient
import cat.vonblum.chatogt.usermanagement.producer.clients.fbi.FbiClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringClientConfig {

    @Bean
    fun ciaClient(): CiaClient {
        return CiaClient()
    }

    @Bean
    fun fbiClient(): FbiClient {
        return FbiClient()
    }

}