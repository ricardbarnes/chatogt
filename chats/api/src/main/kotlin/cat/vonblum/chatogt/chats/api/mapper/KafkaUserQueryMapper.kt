package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.shared.domain.query.Query
import cat.vonblum.chatogt.shared.domain.query.Response
import cat.vonblum.chatogt.chats.users.find.FindUserByNameResponse
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaUserQueryMapper(private val gson: Gson) {

    fun toFindUserIdByNameQuery(response: String?): Response? {
        return gson.fromJson(response, FindUserByNameResponse::class.java)
    }

    fun toDto(query: Query): String? {
        return gson.toJson(query)
    }

}