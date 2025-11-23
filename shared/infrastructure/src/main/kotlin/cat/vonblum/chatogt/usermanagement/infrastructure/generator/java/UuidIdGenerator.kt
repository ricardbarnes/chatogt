package cat.vonblum.chatogt.usermanagement.infrastructure.generator.java

import cat.vonblum.chatogt.usermanagement.domain.generator.IdGenerator
import java.util.UUID

class UuidIdGenerator : IdGenerator {

    override fun next(): UUID {
        return UUID.randomUUID()
    }

}