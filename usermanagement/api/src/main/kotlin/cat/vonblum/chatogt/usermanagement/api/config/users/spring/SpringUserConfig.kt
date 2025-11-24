package cat.vonblum.chatogt.usermanagement.api.config.users.spring

import cat.vonblum.chatogt.usermanagement.api.controller.users.grpc.GrpcUserMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringUserConfig {

    @Bean
    fun grpcUserMapper(): GrpcUserMapper {
        return GrpcUserMapper()
    }

}