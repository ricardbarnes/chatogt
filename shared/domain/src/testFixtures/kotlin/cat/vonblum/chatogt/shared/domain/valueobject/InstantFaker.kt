package cat.vonblum.chatogt.shared.domain.valueobject

import java.time.Clock
import java.time.Instant

object InstantFaker {

    fun utcNow(): Instant = Instant.now(Clock.systemUTC())

}