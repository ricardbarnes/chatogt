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
import cat.vonblum.chatogt.usermanagement.producer.provider.users.kotlin.KotlinForReportingUsers
import cat.vonblum.chatogt.usermanagement.producer.provider.users.mailchimp.MailchimpForNotifyingUsers
import cat.vonblum.chatogt.usermanagement.producer.provider.users.mailgun.MailgunForNotifyingUsers
import cat.vonblum.chatogt.usermanagement.producer.provider.users.mongo.MongoForFindingUsers
import cat.vonblum.chatogt.usermanagement.producer.provider.users.plivo.PlivoForNotifyingUsers
import cat.vonblum.chatogt.usermanagement.producer.provider.users.shared.UserNotifierResolverImpl
import cat.vonblum.chatogt.usermanagement.producer.provider.users.shared.UserSenderResolverImpl
import cat.vonblum.chatogt.usermanagement.producer.provider.users.twilio.TwilioForNotifyingUsers
import cat.vonblum.chatogt.usermanagement.users.ForFindingUsers
import cat.vonblum.chatogt.usermanagement.users.ForNotifyingUsers
import cat.vonblum.chatogt.usermanagement.users.ForReportingUsers
import cat.vonblum.chatogt.usermanagement.users.UserNotifierResolver
import cat.vonblum.chatogt.usermanagement.users.UserSenderResolver
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
    fun mailchimpForNotifyingUsers(): MailchimpForNotifyingUsers {
        return MailchimpForNotifyingUsers()
    }

    @Bean
    @Profile("prod")
    fun mailgunForNotifyingUsers(): MailgunForNotifyingUsers {
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
    fun userNotifierResolverDev(
        @Qualifier("mailchimpForNotifyingUsers") mailchimp: ForNotifyingUsers,
        @Qualifier("plivoForNotifyingUsers") plivo: ForNotifyingUsers,
    ): UserNotifierResolver {
        return UserNotifierResolverImpl(
            mailchimp,
            plivo
        )
    }

    @Bean
    @Profile("prod")
    fun userNotifierResolverProd(
        @Qualifier("mailgunForNotifyingUsers") mailgun: ForNotifyingUsers,
        @Qualifier("twilioForNotifyingUsers") twilio: ForNotifyingUsers,
    ): UserNotifierResolver {
        return UserNotifierResolverImpl(
            mailgun,
            twilio
        )
    }

    @Bean
    fun forReportingUsers(): ForReportingUsers {
        return KotlinForReportingUsers()
    }

    @Bean
    @Profile("dev")
    fun createUserCommandHandlerDev(
        idGenerator: IdGenerator,
        userSenderResolver: UserSenderResolver,
        userNotifierResolverDev: UserNotifierResolver,
        forReportingUsers: ForReportingUsers,
        eventBus: EventBus
    ): CreateUserCommandHandler {
        return CreateUserCommandHandler(
            idGenerator,
            userSenderResolver,
            userNotifierResolverDev,
            forReportingUsers,
            eventBus
        )
    }

    @Bean
    @Profile("prod")
    fun createUserCommandHandlerProd(
        idGenerator: IdGenerator,
        userSenderResolver: UserSenderResolver,
        userNotifierResolverProd: UserNotifierResolver,
        forReportingUsers: ForReportingUsers,
        eventBus: EventBus
    ): CreateUserCommandHandler {
        return CreateUserCommandHandler(
            idGenerator,
            userSenderResolver,
            userNotifierResolverProd,
            forReportingUsers,
            eventBus
        )
    }

}