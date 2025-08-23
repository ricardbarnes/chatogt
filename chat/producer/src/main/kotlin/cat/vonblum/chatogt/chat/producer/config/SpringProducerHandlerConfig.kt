package cat.vonblum.chatogt.chat.producer.config

import cat.vonblum.chatogt.chat.chats.FindingChats
import cat.vonblum.chatogt.chat.chats.create.CreateChatCommandHandler
import cat.vonblum.chatogt.chat.chats.delete.DeleteChatCommandHandler
import cat.vonblum.chatogt.chat.chats.find.FindChatQueryHandler
import cat.vonblum.chatogt.chat.chats.find.FindChatIdsByUserIdQueryHandler
import cat.vonblum.chatogt.chat.chats.update.UpdateChatCommandHandler
import cat.vonblum.chatogt.chat.messages.FindingMessages
import cat.vonblum.chatogt.chat.messages.ReportingMessages
import cat.vonblum.chatogt.chat.messages.create.CreateMessageCommandHandler
import cat.vonblum.chatogt.chat.messages.delete.DeleteMessageCommandHandler
import cat.vonblum.chatogt.chat.messages.find.FindMessageIdsQueryHandler
import cat.vonblum.chatogt.chat.messages.find.FindMessageQueryHandler
import cat.vonblum.chatogt.chat.messages.update.UpdateMessageCommandHandler
import cat.vonblum.chatogt.shared.domain.annotation.HandlerDefinition
import cat.vonblum.chatogt.shared.domain.annotation.HandlerRegistry
import cat.vonblum.chatogt.shared.domain.event.EventBus
import cat.vonblum.chatogt.shared.domain.generator.HashGenerator
import cat.vonblum.chatogt.shared.domain.generator.IdGenerator
import cat.vonblum.chatogt.shared.domain.handler.Handler
import cat.vonblum.chatogt.shared.infrastructure.generator.Argon2HashGenerator
import cat.vonblum.chatogt.shared.infrastructure.generator.GenericIdGenerator
import cat.vonblum.chatogt.chat.users.FindingUsers
import cat.vonblum.chatogt.chat.users.create.CreateUserCommandHandler
import cat.vonblum.chatogt.chat.users.delete.DeleteUserCommandHandler
import cat.vonblum.chatogt.chat.users.find.FindUserByNameQueryHandler
import cat.vonblum.chatogt.chat.users.update.UpdateUserCommandHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringProducerHandlerConfig {

    @Bean
    fun idGenerator(): IdGenerator {
        return GenericIdGenerator()
    }

    @Bean
    fun hashGenerator(): HashGenerator {
        return Argon2HashGenerator()
    }

    @Bean
    fun handler(handlers: List<Any>): Handler {
        return Handler(handlers)
    }

    @HandlerRegistry
    @Bean
    fun handlers(
        createChatCommandHandler: CreateChatCommandHandler,
        updateChatCommandHandler: UpdateChatCommandHandler,
        deleteChatCommandHandler: DeleteChatCommandHandler,
        findChatQueryHandler: FindChatQueryHandler,
        createMessageCommandHandler: CreateMessageCommandHandler,
        deleteMessageCommandHandler: DeleteMessageCommandHandler,
        findMessageIdsQueryHandler: FindMessageIdsQueryHandler,
        findMessageQueryHandler: FindMessageQueryHandler,
        updateMessageCommandHandler: UpdateMessageCommandHandler,
        createUserCommandHandler: CreateUserCommandHandler,
        updateUserCommandHandler: UpdateUserCommandHandler,
        deleteUserCommandHandler: DeleteUserCommandHandler,
        findChatIdsByUserIdQueryHandler: FindChatIdsByUserIdQueryHandler,
        findUserByNameQueryHandler: FindUserByNameQueryHandler
    ): List<Any> {
        return listOf(
            createChatCommandHandler,
            updateChatCommandHandler,
            deleteChatCommandHandler,
            findChatQueryHandler,
            createMessageCommandHandler,
            deleteMessageCommandHandler,
            findMessageIdsQueryHandler,
            findMessageQueryHandler,
            updateMessageCommandHandler,
            createUserCommandHandler,
            updateUserCommandHandler,
            deleteUserCommandHandler,
            findChatIdsByUserIdQueryHandler,
            findUserByNameQueryHandler,
        )
    }

    @HandlerDefinition
    @Bean
    fun createUserCommandHandler(
        eventBus: EventBus,
        idGenerator: IdGenerator,
        hashGenerator: HashGenerator,
    ): CreateUserCommandHandler {
        return CreateUserCommandHandler(eventBus, idGenerator, hashGenerator)
    }

    @HandlerDefinition
    @Bean
    fun updateUserCommandHandler(): UpdateUserCommandHandler {
        return UpdateUserCommandHandler()
    }

    @HandlerDefinition
    @Bean
    fun deleteUserCommandHandler(): DeleteUserCommandHandler {
        return DeleteUserCommandHandler()
    }

    @HandlerDefinition
    @Bean
    fun createChatCommandHandler(
        eventBus: EventBus,
        idGenerator: IdGenerator,
    ): CreateChatCommandHandler {
        return CreateChatCommandHandler(eventBus, idGenerator)
    }

    @HandlerDefinition
    @Bean
    fun muteChatCommandHandler(
        findingChats: FindingChats,
        eventBus: EventBus,
    ): UpdateChatCommandHandler {
        return UpdateChatCommandHandler(
            findingChats,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun cancelChatCommandHandler(
        findingChats: FindingChats,
        eventBus: EventBus,
    ): DeleteChatCommandHandler {
        return DeleteChatCommandHandler(
            findingChats,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun findChatQueryHandler(
        findingChats: FindingChats
    ): FindChatQueryHandler {
        return FindChatQueryHandler(findingChats)
    }

    @HandlerDefinition
    @Bean
    fun createMessageCommandHandler(
        eventBus: EventBus,
        idGenerator: IdGenerator,
        reportingMessages: ReportingMessages
    ): CreateMessageCommandHandler {
        return CreateMessageCommandHandler(
            eventBus,
            idGenerator,
            reportingMessages
        )
    }

    @HandlerDefinition
    @Bean
    fun deleteMessageCommandHandler(
        findingMessages: FindingMessages,
        eventBus: EventBus
    ): DeleteMessageCommandHandler {
        return DeleteMessageCommandHandler(
            findingMessages,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun findMessageIdsQueryHandler(
        findingMessages: FindingMessages
    ): FindMessageIdsQueryHandler {
        return FindMessageIdsQueryHandler(findingMessages)
    }

    @HandlerDefinition
    @Bean
    fun findMessageQueryHandler(
        findingMessages: FindingMessages
    ): FindMessageQueryHandler {
        return FindMessageQueryHandler(findingMessages)
    }

    @HandlerDefinition
    @Bean
    fun updateMessageCommandHandler(
        findingMessages: FindingMessages,
        eventBus: EventBus
    ): UpdateMessageCommandHandler {
        return UpdateMessageCommandHandler(
            findingMessages,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun findChatsByUserIdQueryHandler(
        findingChats: FindingChats
    ): FindChatIdsByUserIdQueryHandler {
        return FindChatIdsByUserIdQueryHandler(findingChats)
    }

    @HandlerDefinition
    @Bean
    fun findUserIdByNameQueryHandler(
        findingUsers: FindingUsers
    ): FindUserByNameQueryHandler {
        return FindUserByNameQueryHandler(findingUsers)
    }

}