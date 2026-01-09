package cat.vonblum.chatogt.usermanagement.shared.event.mongo

import cat.vonblum.chatogt.usermanagement.domain.event.Event

class MongoEventMapper {

    fun toInfra(event: Event): ByteArray {
        TODO()
    }

    fun toDomain(type: String, payload: ByteArray): Event {
        TODO()
    }

}