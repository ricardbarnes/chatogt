package cat.vonblum.chatogt.chat.producer.config

import cat.vonblum.chatogt.chat.chats.ForFindingChats
import cat.vonblum.chatogt.chat.chats.create.CreateChatCommandHandler
import cat.vonblum.chatogt.chat.chats.delete.DeleteChatCommandHandler
import cat.vonblum.chatogt.chat.chats.find.FindChatQueryHandler
import cat.vonblum.chatogt.chat.chats.find.FindChatIdsByUserIdQueryHandler
import cat.vonblum.chatogt.chat.chats.update.UpdateChatCommandHandler
import cat.vonblum.chatogt.chat.messages.ForFindingMessages
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
import cat.vonblum.chatogt.chat.users.ForFindingUsers
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
        forFindingChats: ForFindingChats,
        eventBus: EventBus,
    ): UpdateChatCommandHandler {
        return UpdateChatCommandHandler(
            forFindingChats,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun cancelChatCommandHandler(
        forFindingChats: ForFindingChats,
        eventBus: EventBus,
    ): DeleteChatCommandHandler {
        return DeleteChatCommandHandler(
            forFindingChats,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun findChatQueryHandler(
        forFindingChats: ForFindingChats
    ): FindChatQueryHandler {
        return FindChatQueryHandler(forFindingChats)
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
        forFindingMessages: ForFindingMessages,
        eventBus: EventBus
    ): DeleteMessageCommandHandler {
        return DeleteMessageCommandHandler(
            forFindingMessages,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun findMessageIdsQueryHandler(
        forFindingMessages: ForFindingMessages
    ): FindMessageIdsQueryHandler {
        return FindMessageIdsQueryHandler(forFindingMessages)
    }

    @HandlerDefinition
    @Bean
    fun findMessageQueryHandler(
        forFindingMessages: ForFindingMessages
    ): FindMessageQueryHandler {
        return FindMessageQueryHandler(forFindingMessages)
    }

    @HandlerDefinition
    @Bean
    fun updateMessageCommandHandler(
        forFindingMessages: ForFindingMessages,
        eventBus: EventBus
    ): UpdateMessageCommandHandler {
        return UpdateMessageCommandHandler(
            forFindingMessages,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun findChatsByUserIdQueryHandler(
        forFindingChats: ForFindingChats
    ): FindChatIdsByUserIdQueryHandler {
        return FindChatIdsByUserIdQueryHandler(forFindingChats)
    }

    @HandlerDefinition
    @Bean
    fun findUserIdByNameQueryHandler(
        forFindingUsers: ForFindingUsers
    ): FindUserByNameQueryHandler {
        return FindUserByNameQueryHandler(forFindingUsers)
    }

}