package cat.vonblum.chatogt.usermanagement.producer.config.users.spring

import cat.vonblum.chatogt.usermanagement.domain.command.Command
import cat.vonblum.chatogt.usermanagement.domain.command.CommandHandler
import cat.vonblum.chatogt.usermanagement.domain.command.CommandHandlerDispatcher
import cat.vonblum.chatogt.usermanagement.domain.event.EventBus
import cat.vonblum.chatogt.usermanagement.domain.generator.IdGenerator
import cat.vonblum.chatogt.usermanagement.producer.clients.cia.Auth0Client
import cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka.KafkaUserCommandHandler
import cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka.KafkaUserCommandMapper
import cat.vonblum.chatogt.usermanagement.producer.provider.users.auth0.Auth0ForSendingUsers
import cat.vonblum.chatogt.usermanagement.producer.provider.users.mailchimp.MailchimpForNotifyingUsers
import cat.vonblum.chatogt.usermanagement.producer.provider.users.mailgun.MailgunForNotifyingUsers
import cat.vonblum.chatogt.usermanagement.producer.provider.users.mongo.MongoForFindingUsers
import cat.vonblum.chatogt.usermanagement.producer.provider.users.plivo.PlivoForNotifyingUsers
import cat.vonblum.chatogt.usermanagement.users.UserNotificationStrategyResolver
import cat.vonblum.chatogt.usermanagement.producer.provider.users.twilio.TwilioForNotifyingUsers
import cat.vonblum.chatogt.usermanagement.users.ForFindingUsers
import cat.vonblum.chatogt.usermanagement.users.ForNotifyingUsers
import cat.vonblum.chatogt.usermanagement.users.UserNotificationType
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommand
import cat.vonblum.chatogt.usermanagement.users.create.CreateUserCommandHandler
import cat.vonblum.chatogt.usermanagement.users.find.FindUserByIdQueryHandler
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import kotlin.reflect.KClass

@Configuration
class SpringUserConfig {

    @Bean
    fun mongoFinding(): ForFindingUsers {
        return MongoForFindingUsers()
    }

    @Bean
    fun userCommandHandlerMap(
        createUserCommandHandler: CreateUserCommandHandler
    ): Map<KClass<out Command>, CommandHandler> {
        return mapOf(
            CreateUserCommand::class as KClass<out Command>
                    to createUserCommandHandler as CommandHandler,
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

    @Bean
    @Profile("dev")
    fun mailchimpForNotifyingUsers(): ForNotifyingUsers {
        return MailchimpForNotifyingUsers()
    }

    @Bean
    @Profile("prod")
    fun mailgunForNotifyingUsers(): ForNotifyingUsers {
        return MailgunForNotifyingUsers()
    }

    @Bean
    @Profile("dev")
    fun plivoForNotifyingUsers(): ForNotifyingUsers {
        return PlivoForNotifyingUsers()
    }

    @Bean
    @Profile("prod")
    fun twilioForNotifyingUsers(): ForNotifyingUsers {
        return TwilioForNotifyingUsers()
    }

    @Bean
    @Profile("dev")
    fun userNotifiersDev(
        mailchimpForNotifyingUsers: ForNotifyingUsers,
        plivoForNotifyingUsers: ForNotifyingUsers,
    ): Map<UserNotificationType, ForNotifyingUsers> {
        return mapOf(
            UserNotificationType.EMAIL to mailchimpForNotifyingUsers,
            UserNotificationType.SMS to plivoForNotifyingUsers,
        )
    }

    @Bean
    @Profile("prod")
    fun userNotifiersProd(
        mailgunForNotifyingUsers: ForNotifyingUsers,
        twilioForNotifyingUsers: ForNotifyingUsers,
    ): Map<UserNotificationType, ForNotifyingUsers> {
        return mapOf(
            UserNotificationType.EMAIL to mailgunForNotifyingUsers,
            UserNotificationType.SMS to twilioForNotifyingUsers,
        )
    }

    @Bean
    fun userNotificationStrategyResolverProd(
        notifiers: Map<UserNotificationType, ForNotifyingUsers>
    ): UserNotificationStrategyResolver {
        return UserNotificationStrategyResolver(
            notifiers
        )
    }

    @Bean
    fun auth0ForSendingUsers(auth0Client: Auth0Client): Auth0ForSendingUsers {
        return Auth0ForSendingUsers(auth0Client)
    }

    @Bean
    @Profile("dev")
    fun createUserCommandHandlerDev(
        idGenerator: IdGenerator,
        auth0ForSendingUsers: Auth0ForSendingUsers,
        userNotificationStrategyResolverDev: UserNotificationStrategyResolver,
        eventBus: EventBus
    ): CreateUserCommandHandler {
        return CreateUserCommandHandler(
            idGenerator,
            auth0ForSendingUsers,
            userNotificationStrategyResolverDev,
            eventBus
        )
    }

    @Bean
    @Profile("prod")
    fun createUserCommandHandlerProd(
        idGenerator: IdGenerator,
        auth0ForSendingUsers: Auth0ForSendingUsers,
        userNotificationStrategyResolverProd: UserNotificationStrategyResolver,
        eventBus: EventBus
    ): CreateUserCommandHandler {
        return CreateUserCommandHandler(
            idGenerator,
            auth0ForSendingUsers,
            userNotificationStrategyResolverProd,
            eventBus
        )
    }

}