package cat.vonblum.chatogt.shared.infrastructure.bus.shared

import java.time.Instant
import java.util.UUID

data class MessageEnvelope(
    val id: UUID = UUID.randomUUID(),
    val aggregate: String,
    val type: String,
    val name: String,
    val key: String = UUID.randomUUID().toString(),
    val payload: Any,
    val metadata: Map<String, String> = emptyMap(),
    val timestamp: Instant = Instant.now()
)