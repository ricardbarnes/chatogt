package cat.vonblum.chatogt.usermanagement.api.bus

import cat.vonblum.chatogt.shared.domain.query.Query
import cat.vonblum.chatogt.shared.domain.query.QueryBus
import cat.vonblum.chatogt.shared.domain.query.Response
import org.springframework.stereotype.Component

@Component
class KafkaQueryBus : QueryBus {

    override fun ask(query: Query): Response? {
        TODO("Not yet implemented")
    }

}