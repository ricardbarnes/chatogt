package cat.vonblum.chatogt.chat.api.bus.shared.query.kafka

import cat.vonblum.chatogt.chat.users.find.FindUserByNameResponse
import cat.vonblum.chatogt.usermanagement.domain.query.Query
import cat.vonblum.chatogt.usermanagement.domain.query.Response
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