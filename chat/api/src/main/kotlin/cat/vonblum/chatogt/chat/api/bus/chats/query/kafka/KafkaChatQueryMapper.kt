package cat.vonblum.chatogt.chat.api.bus.chats.query.kafka

import cat.vonblum.chatogt.chat.chats.find.FindChatIdsByUserIdResponse
import cat.vonblum.chatogt.chat.chats.find.FindChatResponse
import cat.vonblum.chatogt.usermanagement.domain.query.Response
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaChatQueryMapper(private val gson: Gson) {

    fun toFindChatIdsByUserIdResponse(response: String?): Response? {
        return gson.fromJson(response, FindChatIdsByUserIdResponse::class.java)
    }

    fun toFindChatQuery(response: String?): Response? {
        return gson.fromJson(response, FindChatResponse::class.java)
    }

}