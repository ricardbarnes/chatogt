package cat.vonblum.chatogt.shared.infrastructure.bus.query.kafka

import cat.vonblum.chatogt.shared.domain.query.Query

class KafkaUnsupportedQueryException private constructor(message: String) :
    RuntimeException(message) {

    companion object {

        fun becauseOf(query: Query): KafkaUnsupportedQueryException {
            val className = query::class.qualifiedName ?: query::class.simpleName ?: "Unknown"
            return KafkaUnsupportedQueryException("Unsupported command type $className")
        }

    }

}
