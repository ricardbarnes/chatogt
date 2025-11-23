package cat.vonblum.chatogt.chat.producer.handler.query.kafka

import cat.vonblum.chatogt.chat.chats.find.FindChatIdsByUserIdQuery
import cat.vonblum.chatogt.chat.chats.find.FindChatQuery
import cat.vonblum.chatogt.usermanagement.domain.query.Response
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaQueryMapper(private val gson: Gson) {

    fun toFindChatIdsByUserIdQuery(json: String): FindChatIdsByUserIdQuery {
        return gson.fromJson(json, FindChatIdsByUserIdQuery::class.java)
    }

    fun toFindChatQuery(json: String): FindChatQuery {
        return gson.fromJson(json, FindChatQuery::class.java)
    }

    fun toDto(response: Response): String? {
        return gson.toJson(response)
    }

}