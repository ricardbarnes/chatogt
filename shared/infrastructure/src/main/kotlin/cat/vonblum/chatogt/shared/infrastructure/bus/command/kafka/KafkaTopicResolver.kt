package cat.vonblum.chatogt.shared.infrastructure.bus.command.kafka

import cat.vonblum.chatogt.shared.infrastructure.bus.command.shared.MessageEnvelope

/**
 * Resolves Kafka topic names for messages (commands, queries, responses)
 * based on a strict naming convention.
 *
 * ## Convention
 * Topics are generated using the following format:
 *
 * ```
 * <aggregate>.<typePlural>
 * ```
 *
 * Supported types:
 * - `"command"` → `"commands"`
 * - `"query"` → `"queries"`
 * - `"response"` → `"responses"`
 *
 * ## Examples
 * ```
 * MessageEnvelope(aggregate = "users", type = "command", ...)
 *   -> "users.commands"
 *
 * MessageEnvelope(aggregate = "users", type = "query", ...)
 *   -> "users.queries"
 *
 * MessageEnvelope(aggregate = "chats", type = "response", ...)
 *   -> "chats.responses"
 * ```
 *
 * ## Notes
 * - Only the three types above are supported. Any other type will throw an exception.
 * - Use this resolver when you want convention-based topic names.
 *   For explicit, configurable topics, a custom class.
 */
class KafkaTopicResolver {

    /**
     * Resolve the Kafka topic name for a given [MessageEnvelope].
     *
     * @param envelope the message to resolve the topic for
     * @return the Kafka topic name
     * @throws IllegalArgumentException if the message type is unsupported
     */
    fun resolve(envelope: MessageEnvelope): String {
        val typePlural = when (envelope.type.lowercase()) {
            "command" -> "commands"
            "query" -> "queries"
            "response" -> "responses"
            else -> throw IllegalArgumentException(
                "Unsupported message type: '${envelope.type}'. " +
                        "Expected one of: command, query, response."
            )
        }

        return "${envelope.aggregate}.$typePlural"
    }

}
