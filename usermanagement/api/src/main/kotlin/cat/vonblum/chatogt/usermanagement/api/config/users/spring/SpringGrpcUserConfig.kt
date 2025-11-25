package cat.vonblum.chatogt.usermanagement.api.config.users.spring

import cat.vonblum.chatogt.usermanagement.api.controller.users.grpc.GrpcUserController
import cat.vonblum.chatogt.usermanagement.api.controller.users.grpc.GrpcUserMapper
import cat.vonblum.chatogt.usermanagement.domain.command.CommandBus
import cat.vonblum.chatogt.usermanagement.domain.query.QueryBus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringGrpcUserConfig {

    @Bean
    fun grpcUserMapper(): GrpcUserMapper {
        return GrpcUserMapper()
    }

    @Bean
    fun grpcUserController(
        mapper: GrpcUserMapper,
        commandBus: CommandBus,
        queryBus: QueryBus
    ): GrpcUserController {
        return GrpcUserController(
            mapper,
            commandBus,
            queryBus
        )
    }

}