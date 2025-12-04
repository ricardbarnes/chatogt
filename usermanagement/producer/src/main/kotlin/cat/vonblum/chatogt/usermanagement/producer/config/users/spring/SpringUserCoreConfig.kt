package cat.vonblum.chatogt.usermanagement.producer.config.users.spring

import cat.vonblum.chatogt.usermanagement.producer.provider.users.mongo.MongoForFindingUsers
import cat.vonblum.chatogt.usermanagement.users.ForFindingUsers
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringUserCoreConfig {

    @Bean
    fun mongoFinding(): ForFindingUsers {
        return MongoForFindingUsers()
    }

}