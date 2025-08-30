package cat.vonblum.chatogt.shared.infrastructure.bus.query.kafka

import cat.vonblum.chatogt.shared.domain.query.Query

class KafkaUnsupportedQueryException private constructor(message: String) :
    RuntimeException(message) {

    companion object {

        fun becauseOf(command: Query): KafkaUnsupportedQueryException {
            val className = command::class.qualifiedName ?: command::class.simpleName ?: "Unknown"
            return KafkaUnsupportedQueryException("Unsupported command type $className")
        }

    }

}
