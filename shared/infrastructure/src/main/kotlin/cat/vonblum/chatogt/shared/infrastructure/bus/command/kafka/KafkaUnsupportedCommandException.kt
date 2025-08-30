package cat.vonblum.chatogt.shared.infrastructure.bus.command.kafka

import cat.vonblum.chatogt.shared.domain.command.Command

class KafkaUnsupportedCommandException private constructor(message: String) :
    RuntimeException(message) {

    companion object {

        fun becauseOf(command: Command): KafkaUnsupportedCommandException {
            val className = command::class.qualifiedName ?: command::class.simpleName ?: "Unknown"
            return KafkaUnsupportedCommandException("Unsupported command type $className")
        }

    }

}
