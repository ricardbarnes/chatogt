package cat.vonblum.chatogt.usermanagement.domain.event

import cat.vonblum.chatogt.usermanagement.domain.annotation.UsedBy
import java.time.Instant
import java.util.*

@Suppress("unused")
@UsedBy("events")
abstract class Event(
    val aggregateId: UUID,
    val id: UUID,
    val occurredOn: Instant,
)