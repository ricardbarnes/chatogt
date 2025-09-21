package cat.vonblum.chatogt.usermanagement.producer.config.users.spring

import cat.vonblum.chatogt.usermanagement.users.ForFindingUsers
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByIdQueryHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringUserQueryConfig {

    @Bean
    fun findUserByIdQueryHandler(finding: ForFindingUsers): FindUserByIdQueryHandler {
        return FindUserByIdQueryHandler(finding)
    }

}