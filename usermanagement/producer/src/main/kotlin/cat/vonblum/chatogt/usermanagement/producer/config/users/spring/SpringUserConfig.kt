package cat.vonblum.chatogt.usermanagement.producer.config.users.spring

import cat.vonblum.chatogt.usermanagement.domain.command.Command
import cat.vonblum.chatogt.usermanagement.domain.command.CommandHandler
import cat.vonblum.chatogt.usermanagement.domain.command.CommandHandlerDispatcher
import cat.vonblum.chatogt.usermanagement.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.domain.generator.IdGenerator
import cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka.KafkaUserCommandHandler
import cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka.KafkaUserCommandMapper
import cat.vonblum.chatogt.usermanagement.producer.provider.users.cia.CiaForSendingUsers
import cat.vonblum.chatogt.usermanagement.producer.provider.users.fbi.FbiForSendingUsers
import cat.vonblum.chatogt.usermanagement.producer.provider.users.mongo.MongoForFindingUsers
import cat.vonblum.chatogt.usermanagement.producer.provider.users.shared.UserSenderResolverImpl
import cat.vonblum.chatogt.usermanagement.users.ForFindingUsers
import cat.vonblum.chatogt.usermanagement.users.ForSendingUsers
import cat.vonblum.chatogt.usermanagement.users.UserSenderResolver
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommandHandler
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByIdQueryHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.reflect.KClass

@Configuration
class SpringUserConfig {

    @Bean
    fun mongoFinding(): ForFindingUsers {
        return MongoForFindingUsers()
    }

    @Bean
    fun fbiForSendingUsers(): FbiForSendingUsers {
        return FbiForSendingUsers()
    }

    @Bean
    fun ciaForSendingUsers(): CiaForSendingUsers {
        return CiaForSendingUsers()
    }

    @Bean
    fun userSenderResolver(
        fbiForSendingUsers: FbiForSendingUsers,
        ciaForSendingUsers: CiaForSendingUsers,
    ): UserSenderResolver {
        return UserSenderResolverImpl(
            fbiForSendingUsers,
            ciaForSendingUsers,
        )
    }

    @Bean
    fun createUserCommandHandler(
        idGenerator: IdGenerator,
        userSenderResolver: UserSenderResolver,
        eventBus: EventBus
    ): CreateUserCommandHandler {
        return CreateUserCommandHandler(
            idGenerator,
            userSenderResolver,
            eventBus
        )
    }

    @Bean
    fun userCommandHandlerMap(
        createUserCommandHandler: CreateUserCommandHandler
    ): Map<KClass<out Command>, CommandHandler> {
        return mapOf(
            CreateUserCommand::class as KClass<out Command> to createUserCommandHandler as CommandHandler,
        )
    }

    @Bean
    fun userCommandHandlerDispatcher(
        userCommandHandlerMap: Map<KClass<out Command>, CommandHandler>
    ): CommandHandlerDispatcher {
        return CommandHandlerDispatcher(userCommandHandlerMap)
    }

    @Bean
    fun kafkaUserCommandMapper(): KafkaUserCommandMapper {
        return KafkaUserCommandMapper()
    }

    @Bean
    fun kafkaUserCommandHandler(
        commandHandlerDispatcher: CommandHandlerDispatcher,
        mapper: KafkaUserCommandMapper,
    ): KafkaUserCommandHandler {
        return KafkaUserCommandHandler(
            commandHandlerDispatcher,
            mapper
        )
    }

    @Bean
    fun findUserByIdQueryHandler(finding: ForFindingUsers): FindUserByIdQueryHandler {
        return FindUserByIdQueryHandler(finding)
    }

}