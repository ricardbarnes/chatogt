package cat.vonblum.chatogt.chats.producer.handler.query

import cat.vonblum.chatogt.chats.chats.find.FindChatIdsByUserIdQuery
import cat.vonblum.chatogt.chats.chats.find.FindChatQuery
import cat.vonblum.chatogt.shared.domain.query.Response
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