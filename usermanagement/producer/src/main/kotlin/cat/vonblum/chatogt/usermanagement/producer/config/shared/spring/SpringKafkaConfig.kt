package cat.vonblum.chatogt.usermanagement.producer.config.shared.spring

import cat.vonblum.chatogt.shared.domain.command.Command
import cat.vonblum.chatogt.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.shared.domain.event.EventBus
import cat.vonblum.chatogt.shared.domain.query.Query
import cat.vonblum.chatogt.shared.domain.query.QueryHandler
import cat.vonblum.chatogt.shared.infrastructure.io.message.MessageResolver
import cat.vonblum.chatogt.usermanagement.producer.bus.event.kafka.KafkaEventBus
import cat.vonblum.chatogt.usermanagement.producer.handler.shared.kafka.KafkaMessageMapper
import cat.vonblum.chatogt.usermanagement.producer.handler.shared.kafka.KafkaMessageResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.reflect.KClass

@Configuration
class SpringKafkaConfig {

    @Bean
    fun eventBus(): EventBus {
        return KafkaEventBus()
    }

    @Bean
    fun kafkaMessageMapper(): KafkaMessageMapper {
        return KafkaMessageMapper()
    }

    @Bean
    fun kafkaMessageResolver(
        commandHandlers: Map<KClass<out Command>, CommandHandler>,
        queryHandlers: Map<KClass<out Query>, QueryHandler>,
        mapper: KafkaMessageMapper
    ): MessageResolver {
        return KafkaMessageResolver(
            commandHandlers,
            queryHandlers,
            mapper
        )
    }

}
