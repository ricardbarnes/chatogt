package cat.vonblum.chatogt.shared.infrastructure.generator

import cat.vonblum.chatogt.shared.domain.generator.IdGenerator
import java.util.*

class GenericIdGenerator : IdGenerator {

    override fun next(): UUID {
        return UUID.randomUUID()
    }

}