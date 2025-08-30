package cat.vonblum.chatogt.shared.infrastructure.generator.java

import cat.vonblum.chatogt.shared.domain.generator.IdGenerator
import java.util.UUID

class UuidIdGenerator : IdGenerator {

    override fun next(): UUID {
        return UUID.randomUUID()
    }

}